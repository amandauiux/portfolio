package com.amandabicalho.portfolio.core.foundation.layout

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.amandabicalho.portfolio.core.ui.unit.Dp
import com.amandabicalho.portfolio.core.ui.unit.dp
import org.jetbrains.compose.web.css.plus

@Stable
interface PaddingValues

/**
 * The padding to be applied along the left edge inside a box.
 */
@Stable
inline fun <reified T> PaddingValues.calculateLeftPadding(layoutDirection: LayoutDirection): T {
    require(this is PaddingValuesImpl)
    return start as T
}

/**
 * The padding to be applied along the top edge inside a box.
 */
@Stable
inline fun <reified T> PaddingValues.calculateTopPadding(): T {
    require(this is PaddingValuesImpl)
    return top as T
}

/**
 * The padding to be applied along the right edge inside a box.
 */
@Stable
inline fun <reified T> PaddingValues.calculateRightPadding(layoutDirection: LayoutDirection): T {
    require(this is PaddingValuesImpl)
    return end as T
}

/**
 * The padding to be applied along the bottom edge inside a box.
 */
@Stable
inline fun <reified T> PaddingValues.calculateBottomPadding(): T {
    require(this is PaddingValuesImpl)
    return bottom as T
}

/**
 * The padding to be applied along the left edge inside a box.
 */
fun PaddingValues.calculateLeftPadding(): Dp =
    calculateLeftPadding(LayoutDirection.Default)

/**
 * The padding to be applied along the top edge inside a box.
 */
fun PaddingValues.calculateTopPadding(): Dp =
    calculateTopPadding<Dp>()

/**
 * The padding to be applied along the right edge inside a box.
 */
fun PaddingValues.calculateRightPadding(): Dp =
    calculateRightPadding(LayoutDirection.Default)

/**
 * The padding to be applied along the bottom edge inside a box.
 */
fun PaddingValues.calculateBottomPadding(): Dp =
    calculateBottomPadding<Dp>()

/**
 * The padding to be applied along the vertical edge inside a box.
 */
fun PaddingValues.calculateVerticalPadding(): Dp =
    Dp(calculateTopPadding<Dp>() + calculateBottomPadding<Dp>())

/**
 * The padding to be applied along the horizontal edge inside a box.
 */
fun PaddingValues.calculateHorizontalPadding(layoutDirection: LayoutDirection = LayoutDirection.Default): Dp =
    Dp(calculateLeftPadding<Dp>(layoutDirection) + calculateRightPadding<Dp>(layoutDirection))

@Immutable
@VisibleForTesting
data class PaddingValuesImpl(
    @Stable
    val start: Dp = 0.dp,
    @Stable
    val top: Dp = 0.dp,
    @Stable
    val end: Dp = 0.dp,
    @Stable
    val bottom: Dp = 0.dp,
) : PaddingValues

@Stable
fun PaddingValues(
    start: Dp = 0.dp,
    top: Dp = 0.dp,
    end: Dp = 0.dp,
    bottom: Dp = 0.dp
): PaddingValues = PaddingValuesImpl(start, top, end, bottom)

@Stable
fun PaddingValues(
    vertical: Dp = 0.dp,
    horizontal: Dp = 0.dp,
): PaddingValues = PaddingValuesImpl(horizontal, vertical, horizontal, vertical)

@Stable
fun PaddingValues(
    all: Dp = 0.dp,
): PaddingValues = PaddingValuesImpl(all, all, all, all)
