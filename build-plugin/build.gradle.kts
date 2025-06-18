plugins {
    `kotlin-dsl`
}

dependencies {
    // Workaround for using version catalog in Kotlin script convention plugins
    // https://github.com/gradle/gradle/issues/15383#issuecomment-779893192
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))

    implementation(plugin(libs.plugins.compose.compiler))
    implementation(plugin(libs.plugins.detekt))
    implementation(plugin(libs.plugins.kotlin.multiplatform))
    implementation(plugin(libs.plugins.kobweb.application))
    implementation(plugin(libs.plugins.kobweb.library))
}

internal fun plugin(provider: Provider<PluginDependency>) = with(provider.get()) {
    "$pluginId:$pluginId.gradle.plugin:$version"
}
