package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.dom.svg.Defs
import com.varabyte.kobweb.compose.dom.svg.Group
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Rect
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineCap
import com.varabyte.kobweb.compose.dom.svg.SVGStrokeLineJoin
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.toAttrs
import org.w3c.css.masking.SVGClipPathElement

@Composable
fun Sun(
    modifier: Modifier = Modifier,
) {
    Svg(
        attrs = modifier.toAttrs {
            attr("viewBox", "0 0 20 20")
            attr("width", "20")
            attr("height", "20")
            attr("fill", "none")
        },
    ) {
        Group(
            attrs = {
                attr("clip-path", "url(#clip0_2955_19800)")
            }
        ) {
            Path {
                d("M11.6428 15.2857C14.207 15.2857 16.2857 13.207 16.2857 10.6429C16.2857 8.07868 14.207 6 11.6428 6C9.07862 6 6.99994 8.07868 6.99994 10.6429C6.99994 13.207 9.07862 15.2857 11.6428 15.2857Z")
                fill(Color.argb(0xFFD9480F))
            }
            Path {
                d("M10 14.6429C12.5642 14.6429 14.6429 12.5642 14.6429 10C14.6429 7.43586 12.5642 5.35718 10 5.35718C7.43583 5.35718 5.35715 7.43586 5.35715 10C5.35715 12.5642 7.43583 14.6429 10 14.6429Z")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M10 0.714355V2.14293")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M10 17.8572V19.2857")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M19.2857 10H17.8571")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M2.14287 10H0.714294")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M16.5714 3.42871L15.5572 4.443")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M4.44287 15.5571L3.42859 16.5714")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M16.5714 16.5714L15.5572 15.5571")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
            Path {
                d("M4.44287 4.443L3.42859 3.42871")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
        }
        Defs {
            GenericTag<SVGClipPathElement>(
                "clipPath",
                attrs = {
                    attr("id", "clip0_2955_19800")
                }
            ) {
                Rect {
                    width(20.0)
                    height(20.0)
                    fill(Colors.White)
                }
            }
        }
    }
}
