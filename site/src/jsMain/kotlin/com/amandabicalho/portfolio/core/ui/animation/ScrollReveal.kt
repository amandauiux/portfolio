package com.amandabicalho.portfolio.core.ui.animation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Transition
import com.varabyte.kobweb.compose.css.TransitionTimingFunction
import com.varabyte.kobweb.compose.dom.disposableRef
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.styleModifier
import kotlinx.browser.window
import org.jetbrains.compose.web.css.ms
import org.jetbrains.compose.web.css.s

private val EaseOutQuart = TransitionTimingFunction.cubicBezier(0.25, 1.0, 0.5, 1.0)

/**
 * Wraps content in a container that fades and slides up when scrolled into view.
 * Uses IntersectionObserver to trigger the animation once.
 *
 * @param delay Transition delay in milliseconds for staggering sibling elements.
 * @param modifier Additional modifier for the container.
 * @param content The composable content to reveal.
 */
@Composable
fun ScrollReveal(
    modifier: Modifier = Modifier,
    delay: Int = 0,
    content: @Composable () -> Unit,
) {
    var isRevealed by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .opacity(if (isRevealed) 1f else 0f)
            .styleModifier {
                property("transform", if (isRevealed) "translateY(0)" else "translateY(20px)")
                property("will-change", "opacity, transform")
            }
            .transition(
                Transition.of(
                    property = "opacity",
                    duration = 0.6.s,
                    timingFunction = EaseOutQuart,
                    delay = delay.ms,
                ),
                Transition.of(
                    property = "transform",
                    duration = 0.6.s,
                    timingFunction = EaseOutQuart,
                    delay = delay.ms,
                ),
            ),
        ref = disposableRef { element ->
            val prefersReducedMotion = window.matchMedia("(prefers-reduced-motion: reduce)").matches
            if (prefersReducedMotion) {
                isRevealed = true
                return@disposableRef onDispose {}
            }

            val observer = createRevealObserver(element, threshold = 0.1) {
                isRevealed = true
            }

            onDispose {
                observer.disconnect()
            }
        },
    ) {
        content()
    }
}
