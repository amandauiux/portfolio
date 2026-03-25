package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGFillType
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineCap
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineJoin
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    strokeColor: Color = Theme.colorScheme.text,
) {
    Svg(
        attrs = modifier.toAttrs {
            width(40)
            height(40)
            viewBox(x = 0, y = 0, width = 40, height = 40)
            fill(SVGFillType.None)
            attr("xmlns", "http://www.w3.org/2000/svg")
        }
    ) {
        Path {
            d("M29.2858 12.8572H10.7144")
            stroke(strokeColor)
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
        Path {
            d("M29.2858 20H10.7144")
            stroke(strokeColor)
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
        Path {
            d("M29.2858 27.1428H10.7144")
            stroke(strokeColor)
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
    }
}
