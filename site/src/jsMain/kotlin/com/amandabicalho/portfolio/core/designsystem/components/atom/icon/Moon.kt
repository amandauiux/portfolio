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
fun Moon(
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
                attr("clip-path", "url(#clip0_2955_19816)")
            }
        ) {
            Path {
                d("M18.1428 15.9715C16.4832 15.9614 14.8563 15.51 13.4287 14.6638C12.0011 13.8176 10.8242 12.607 10.0188 11.156C9.21333 9.705 8.80827 8.06591 8.84511 6.40677C8.88196 4.74763 9.3594 3.12815 10.2285 1.71436C7.93873 2.11633 5.88061 3.35627 4.45504 5.19264C3.02947 7.02902 2.33853 9.3303 2.51684 11.6482C2.69514 13.9661 3.7299 16.1347 5.41956 17.7314C7.10922 19.3282 9.33276 20.2387 11.657 20.2858C13.2472 20.2898 14.8115 19.8829 16.1981 19.1045C17.5847 18.3261 18.7467 17.2026 19.5713 15.8429C19.099 15.921 18.6215 15.964 18.1428 15.9715Z")
                fill(Color.argb(0xFFD9480F))
            }
            Path {
                d("M17.1428 14.9715C15.4832 14.9614 13.8563 14.51 12.4287 13.6638C11.0011 12.8176 9.82424 11.607 9.01879 10.156C8.21333 8.705 7.80827 7.06591 7.84511 5.40677C7.88196 3.74763 8.3594 2.12815 9.22847 0.714355C6.93873 1.11633 4.88061 2.35627 3.45504 4.19264C2.02947 6.02902 1.33853 8.3303 1.51684 10.6482C1.69514 12.9661 2.7299 15.1347 4.41956 16.7314C6.10922 18.3282 8.33276 19.2387 10.657 19.2858C12.2472 19.2898 13.8115 18.8829 15.1981 18.1045C16.5847 17.3261 17.7467 16.2026 18.5713 14.8429C18.099 14.921 17.6215 14.964 17.1428 14.9715Z")
                stroke(Color.argb(0xFF141414))
                strokeLineCap(SVGStrokeLineCap.Round)
                strokeLineJoin(SVGStrokeLineJoin.Round)
            }
        }
        Defs {
            GenericTag<SVGClipPathElement>(
                "clipPath",
                attrs = {
                    attr("id", "clip0_2955_19816")
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
