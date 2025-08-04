package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineCap
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineJoin
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun Circle(
    modifier: Modifier = Modifier,
) {
    Svg(
        attrs = modifier.toAttrs {
            attr("width", "12")
            attr("height", "13")
            attr("viewBox", "0 0 12 13")
            attr("fill", "none")
            attr("xmlns", "http://www.w3.org/2000/svg")
        }
    ) {
        Path {
            d("M6.75 12.2083C9.6495 12.2083 12 9.85775 12 6.95825C12 4.05876 9.6495 1.70825 6.75 1.70825C3.8505 1.70825 1.5 4.05876 1.5 6.95825C1.5 9.85775 3.8505 12.2083 6.75 12.2083Z")
            fill(Color.argb(0xFFD9480F))
        }
        Path {
            d("M6 11.5834C8.8995 11.5834 11.25 9.23287 11.25 6.33337C11.25 3.43388 8.8995 1.08337 6 1.08337C3.1005 1.08337 0.75 3.43388 0.75 6.33337C0.75 9.23287 3.1005 11.5834 6 11.5834Z")
            stroke(Color.argb(0xFF1B0902))
            strokeWidth(0.75)
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
    }
}
