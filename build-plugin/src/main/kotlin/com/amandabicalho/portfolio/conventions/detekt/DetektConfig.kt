package com.amandabicalho.portfolio.conventions.detekt

import com.amandabicalho.portfolio.conventions.Versions


object DetektConfig {
    val JavaVersion = Versions.JavaVersion.toString()
    val ExcludedDirs = setOf("build", "playground")
}
