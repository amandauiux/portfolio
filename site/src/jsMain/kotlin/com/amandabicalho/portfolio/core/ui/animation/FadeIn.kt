package com.amandabicalho.portfolio.core.ui.animation

import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier

/**
 * Modifier that plays a simple fade-in CSS animation on mount.
 * Use for conditionally rendered elements like overlays.
 *
 * Requires the `fadeIn` keyframes to be registered globally in AppStyles.
 */
fun Modifier.fadeInAnimation(durationMs: Int = 200): Modifier = this
    .styleModifier {
        property("animation", "fadeIn ${durationMs}ms cubic-bezier(0.25, 1, 0.5, 1) forwards")
    }
