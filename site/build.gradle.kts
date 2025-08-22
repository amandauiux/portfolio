import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import io.github.skeptick.libres.plugin.LibresImagesGenerationTask
import io.github.skeptick.libres.plugin.LibresStringGenerationTask
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import java.util.Properties
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.detekt)
    alias(libs.plugins.libres)
    alias(libs.plugins.com.github.gmazzo.buildconfig)
}

group = "com.amandabicalho.portfolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                link {
                    rel = "stylesheet"
                    href = basePath.prependTo("/fonts/faces.css")
                }
                link {
                    rel = "icon"
                    type = "image/png"
                    href = basePath.prependTo("/favicon-96x96.png")
                    sizes = "96x96"
                }
                link {
                    rel = "icon"
                    type = "image/svg+xml"
                    href = basePath.prependTo("/favicon.svg")
                }
                link {
                    rel = "shortcut icon"
                    href = basePath.prependTo("/favicon.ico")
                }
                link {
                    rel = "apple-touch-icon"
                    sizes = "180x180"
                    href = basePath.prependTo("/apple-touch-icon.png")
                }
                link {
                    rel = "manifest"
                    href = basePath.prependTo("/site.webmanifest")
                }
            }
            description.set(
                "Explore my UX UI design portfolio featuring a curated collection of design projects and " +
                    "insightful case studies. Discover my approach and expertise as a designer.",
            )
        }
    }

    markdown {
        process.set { entries ->
            val projects = entries.map { entry ->
                val frontMatter = entry.frontMatter
                val title = frontMatter["title"]
                    ?.singleOrNull()
                    ?: error("Markdown file must set \"title\" in frontmatter")
                val tags = frontMatter["tags"]
                    ?.takeIf { it.isNotEmpty() }
                    ?: error("Markdown file must set \"tags\" in frontmatter")
                val image = frontMatter["thumbnail"]
                    ?.singleOrNull()
                    ?: error("Markdown file must set \"thumbnail\" in frontmatter")
                val publishedAt = frontMatter["published_at"]
                    ?.singleOrNull()
                    ?: error("Markdown file must set \"published_at\" in frontmatter")
                """
                    |Project(
                    |    title = "$title",
                    |    image = "$image",
                    |    route = "${entry.route}",
                    |    tags = listOf(${tags.joinToString { "\"$it\"" }}),
                    |    publishedAt = LocalDateTime.parse("$publishedAt"),
                    |),
                """.trimMargin()
            }

            val content = """
                |package com.amandabicalho.portfolio.domain
                |
                |import kotlinx.datetime.LocalDateTime
                |
                |data class Project(
                |    val title: String,
                |    val image: String,
                |    val route: String,
                |    val tags: List<String>,
                |    val publishedAt: LocalDateTime,
                |)
                |data object Projects {
                |   val entries = listOf(
                |${projects.joinToString("\n").prependIndent("        ")}
                |   )
                |}
            """.trimMargin()


            generateKotlin(filePath = "com/amandabicalho/portfolio/domain/Projects.kt", content)
        }
    }
}

kotlin {
    configAsKobwebApplication("portfolio")

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.libres)
            implementation(libs.kotlinx.datetime)
        }

        jsMain.dependencies {
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.kobwebx.markdown)
            implementation(libs.androidx.annotation)
            implementation(npm(name = "firebase", version = "12.1.0"))
        }
    }
}

libres {
    // https://github.com/Skeptick/libres#setup
    generatedClassName = "Res"
    generateNamedArguments = true
    baseLocaleLanguageCode = "en"
}

detekt {
    autoCorrect = true
    buildUponDefaultConfig = true // preconfigure defaults
    allRules = false // activate all available (even unstable) rules.
    // point to your custom config defining rules to run, overwriting default behavior
    config.setFrom("${rootProject.rootDir}/config/detekt.yml")
}

dependencies {
    detektPlugins(libs.detekt.formatting)
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = JavaVersion.VERSION_17.toString()
    exclude {
        setOf("build").any { dir ->
            dir in it.file.absolutePath
        }
    }

    reports {
        html.required.set(true) // observe findings in your browser with structure and code snippets
        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
        txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
    }
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = JavaVersion.VERSION_17.toString()
}

// Fix libres not explicitly depending on kspKotlinJs
tasks.withType<LibresImagesGenerationTask>().configureEach {
    dependsOn("kspKotlinJs")
}

tasks.withType<LibresStringGenerationTask>().configureEach {
    dependsOn("kspKotlinJs")
}

val localConfig = project.rootProject.file("local.properties")
val props = Properties().apply {
    load(localConfig.reader())
}

buildConfig {
    packageName(group.toString().plus(".config"))
    useKotlinOutput()
    buildConfigField(
        name = "FIREBASE_API_KEY",
        value = props.getProperty("firebase.apiKey"),
    )
    buildConfigField(
        name = "FIREBASE_AUTH_DOMAIN",
        value = props.getProperty("firebase.authDomain"),
    )
    buildConfigField(
        name = "FIREBASE_PROJECT_ID",
        value = props.getProperty("firebase.projectId"),
    )
    buildConfigField(
        name = "FIREBASE_STORAGE_BUCKET",
        value = props.getProperty("firebase.storageBucket"),
    )
    buildConfigField(
        name = "FIREBASE_MESSAGING_SENDER_ID",
        value = props.getProperty("firebase.messagingSenderId"),
    )
    buildConfigField(
        name = "FIREBASE_APP_ID",
        value = props.getProperty("firebase.appId"),
    )
    buildConfigField(
        name = "FIREBASE_MEASUREMENT_ID",
        value = props.getProperty("firebase.measurementId"),
    )
}
