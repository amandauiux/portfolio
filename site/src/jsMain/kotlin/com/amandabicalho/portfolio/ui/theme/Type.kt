package com.amandabicalho.portfolio.ui.theme

import com.amandabicalho.portfolio.core.ui.theme.typography.Regular
import com.amandabicalho.portfolio.core.ui.theme.typography.TextStyle
import com.amandabicalho.portfolio.core.ui.theme.typography.Typography
import com.amandabicalho.portfolio.core.ui.unit.sp
import com.varabyte.kobweb.compose.css.FontWeight

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = Archivo,
        fontWeight = FontWeight.Medium,
        fontSize = 42.sp, // Mobile: 42px
        lineHeight = 50.4.sp, // Mobile: 42px * 1.2
        letterSpacing = 0.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = Archivo,
        fontWeight = FontWeight.Medium,
        fontSize = 36.sp, // Mobile: 36px
        lineHeight = 43.2.sp, // Mobile: 36px * 1.2
        letterSpacing = 0.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = Archivo,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp, // Mobile: 28px
        lineHeight = 33.6.sp, // Mobile: 28px * 1.2
        letterSpacing = 0.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = Archivo,
        fontWeight = FontWeight.Regular,
        fontSize = 26.sp, // Mobile: 26px
        lineHeight = 33.8.sp, // Mobile: 26px * 1.3
        letterSpacing = 0.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = Archivo,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp, // Mobile: 24px
        lineHeight = 31.2.sp, // Mobile: 24px * 1.3
        letterSpacing = 0.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = Archivo,
        fontWeight = FontWeight.Regular,
        fontSize = 20.sp, // Mobile: 20px
        lineHeight = 26.sp, // Mobile: 20px * 1.3
        letterSpacing = 0.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Regular,
        fontSize = 16.sp, // Mobile: 16px
        lineHeight = 24.sp, // Mobile: 16px * 1.5
        letterSpacing = 0.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Regular,
        fontSize = 14.sp, // Mobile: 14px
        lineHeight = 21.sp, // Mobile: 14px * 1.5
        letterSpacing = 0.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = Manrope,
        fontWeight = FontWeight.Regular,
        fontSize = 14.sp, // Mobile: 14px
        lineHeight = 21.sp, // Mobile: 14px * 1.5
        letterSpacing = 0.sp,
    ),
)

val DesktopTypography = Typography.copy(
    headlineLarge = Typography.headlineLarge.copy(
        fontSize = 80.sp,
        lineHeight = 96.sp,
    ),
    headlineMedium = Typography.headlineMedium.copy(
        fontSize = 72.sp,
        lineHeight = 86.4.sp,
    ),
    headlineSmall = Typography.headlineSmall.copy(
        fontSize = 60.sp,
        lineHeight = 72.sp,
    ),
    titleLarge = Typography.titleLarge.copy(
        fontSize = 36.sp,
        lineHeight = 46.8.sp,
    ),
    titleMedium = Typography.titleMedium.copy(
        fontSize = 32.sp,
        lineHeight = 41.6.sp,
    ),
    titleSmall = Typography.titleSmall.copy(
        fontSize = 24.sp,
        lineHeight = 31.2.sp,
    ),
    bodyLarge = Typography.bodyLarge.copy(
        fontSize = 18.sp,
        lineHeight = 27.sp,
    )
)
