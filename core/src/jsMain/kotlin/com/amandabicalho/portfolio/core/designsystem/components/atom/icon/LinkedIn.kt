package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Circle
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineCap
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineJoin
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun LinkedIn(
    modifier: Modifier = Modifier,
) {
    Svg(
        attrs = modifier.toAttrs {
            attr("viewBox", "0 0 46 46")
            width(46)
            height(46)
            attr("fill", "none")
        }
    ) {
//        <circle cx="24" cy="24.667" r="20" fill="#D9480F" />
        Circle {
            cx(24)
            cy(24.667)
            r(20)
            fill(Color.argb(0xFFD9480F))
        }
//        <circle cx="22" cy="22.333" r="19.5" stroke="#141414" />
        Circle {
            cx(22)
            cy(22.333)
            r(19.5)
            stroke(Color.argb(0xFF141414))
        }
//        <path
//        d="M28 18.333C29.5913 18.333 31.1174 18.9651 32.2426 20.0904C33.3679 21.2156 34 22.7417 34 24.333V31.333H30V24.333C30 23.8026 29.7893 23.2939 29.4142 22.9188C29.0391 22.5437 28.5304 22.333 28 22.333C27.4696 22.333 26.9609 22.5437 26.5858 22.9188C26.2107 23.2939 26 23.8026 26 24.333V31.333H22V24.333C22 22.7417 22.6321 21.2156 23.7574 20.0904C24.8826 18.9651 26.4087 18.333 28 18.333Z"
//        stroke="#141414" stroke-linecap="round" stroke-linejoin="round" />
        Path {
            d(
                "M28 18.333C29.5913 18.333 31.1174 18.9651 32.2426 20.0904C33.3679 21.2156 34 22.7417 34 24.333V31.333H30V24.333C30 23.8026 29.7893 23.2939 29.4142 22.9188C29.0391 22.5437 28.5304 22.333 28 22.333C27.4696 22.333 26.9609 22.5437 26.5858 22.9188C26.2107 23.2939 26 23.8026 26 24.333V31.333H22V24.333C22 22.7417 22.6321 21.2156 23.7574 20.0904C24.8826 18.9651 26.4087 18.333 28 18.333Z",
            )
            stroke(Color.argb(0xFF141414))
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
//        <path d="M18 19.333H14V31.333H18V19.333Z" stroke="#141414" stroke-linecap="round"
//        stroke-linejoin="round" />
        Path {
            d("M18 19.333H14V31.333H18V19.333Z")
            stroke(Color.argb(0xFF141414))
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
//        <path
//        d="M16 16.333C17.1046 16.333 18 15.4376 18 14.333C18 13.2284 17.1046 12.333 16 12.333C14.8954 12.333 14 13.2284 14 14.333C14 15.4376 14.8954 16.333 16 16.333Z"
//        stroke="#141414" stroke-linecap="round" stroke-linejoin="round" />
        Path {
            d(
                "M16 16.333C17.1046 16.333 18 15.4376 18 14.333C18 13.2284 17.1046 12.333 16 12.333C14.8954 12.333 14 13.2284 14 14.333C14 15.4376 14.8954 16.333 16 16.333Z",
            )
            stroke(Color.argb(0xFF141414))
            strokeLineCap(SVGStrokeLineCap.Round)
            strokeLineJoin(SVGStrokeLineJoin.Round)
        }
    }
}
