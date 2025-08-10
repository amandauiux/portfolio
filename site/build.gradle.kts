
import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import io.github.skeptick.libres.plugin.LibresImagesGenerationTask
import io.github.skeptick.libres.plugin.LibresStringGenerationTask
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import kotlinx.html.link

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.kobwebx.markdown)
    alias(libs.plugins.detekt)
    alias(libs.plugins.libres)
}

group = "com.amandabicalho.portfolio"
version = "1.0-SNAPSHOT"

kobweb {
    app {
        index {
            head.add {
                link {
                    rel = "stylesheet"
                    href = "/fonts/faces.css"
                }
            }
            description.set("Powered by Kobweb")
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
                val image = frontMatter["hero_image"]
                    ?.singleOrNull()
                    ?: error("Markdown file must set \"hero_image\" in frontmatter")
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
