package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun Close(modifier: Modifier = Modifier) {
    Svg(
        attrs = modifier.toAttrs {
            attr("width", "24")
            attr("height", "24")
            attr("viewBox", "0 -960 960 960")
            attr("fill", "none")
            attr("xmlns", "http://www.w3.org/2000/svg")
        }
    ) {
        Path {
            d("m256-200-56-56 224-224-224-224 56-56 224 224 224-224 56 56-224 224 224 224-56 56-224-224-224 224Z")
            fill(Color.argb(0xFF000001))
        }
    }
}
