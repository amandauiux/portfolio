package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineCap
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineJoin
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun ArrowForward(modifier: Modifier = Modifier) {
    Svg(
        attrs = modifier.toAttrs {
            width(14.dp)
            height(14.dp)
            viewBox(x = 0, y = 0, width = 14, height = 14)
        },
    ) {
        Path {
            d("M1 7.00008H12.6667M12.6667 7.00008L6.83333 1.16675M12.6667 7.00008L6.83333 12.8334")
            stroke(Colors.White)
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
    }
}
