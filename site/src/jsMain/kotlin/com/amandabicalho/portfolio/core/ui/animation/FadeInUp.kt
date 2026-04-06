package com.amandabicalho.portfolio.core.ui.animation

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier

/**
 * Wraps content with a fade-in-up CSS animation that plays on page load.
 * Use for above-the-fold content (hero section) that doesn't need scroll triggering.
 *
 * Requires the `fadeInUp` keyframes to be registered globally in AppStyles.
 *
 * @param delay Animation delay in milliseconds for staggering sibling elements.
 * @param modifier Additional modifier for the container.
 * @param content The composable content to animate.
 */
@Composable
fun FadeInUp(
    modifier: Modifier = Modifier,
    delay: Int = 0,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .styleModifier {
                property("opacity", "0")
                property(
                    "animation",
                    "fadeInUp 0.7s cubic-bezier(0.25, 1, 0.5, 1) ${delay}ms forwards",
                )
            },
    ) {
        content()
    }
}
