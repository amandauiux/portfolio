import com.varabyte.kobweb.gradle.library.util.configAsKobwebLibrary

plugins {
    id("com.amandabicalho.portfolio.kobweb.library")
}

group = "com.amandabicalho.portfolio.core"
version = "1.0-SNAPSHOT"

kotlin {
    configAsKobwebLibrary()

    sourceSets {
        jsMain.dependencies {
            implementation(libs.androidx.annotation)
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            // implementation(libs.kobwebx.markdown)
        }
    }
}
