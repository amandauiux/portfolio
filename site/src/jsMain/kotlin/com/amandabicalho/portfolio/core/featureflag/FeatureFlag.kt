package com.amandabicalho.portfolio.core.featureflag

enum class FeatureFlag(
    val key: String,
    val enabled: Boolean,
    val description: String,
) {
    EnableLightDarkMode(
        key = "enable_light_dark_mode",
        enabled = false,
        description = "Enable light/dark mode toggle",
    ),
    ShowAboutMyselfSection(
        key = "show_about_myself_section",
        enabled = false,
        description = "Show the A bit about myself section on the about page",
    ),
}
