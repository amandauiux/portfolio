import com.amandabicalho.portfolio.conventions.detekt.DetektConfig
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import org.gradle.kotlin.dsl.withType
import kotlin.text.contains

plugins {
    id("io.gitlab.arturbosch.detekt")
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
    jvmTarget = DetektConfig.JavaVersion
    exclude {
        DetektConfig.ExcludedDirs.any { dir ->
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
    jvmTarget = DetektConfig.JavaVersion
}
