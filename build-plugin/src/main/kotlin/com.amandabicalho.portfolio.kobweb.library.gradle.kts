import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary

plugins {
    id("org.jetbrains.kotlin.multiplatform")
    id("org.jetbrains.kotlin.plugin.compose")
    id("com.varabyte.kobweb.library")
    id("com.amandabicalho.portfolio.detekt")
}

kotlin {
    configAsKobwebLibrary()

    sourceSets {
        jsMain.dependencies {
            implementation(libs.androidx.annotation)
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            // implementation(com.amandabicalho.portfolio.libs.kobwebx.markdown)
        }
    }
}
