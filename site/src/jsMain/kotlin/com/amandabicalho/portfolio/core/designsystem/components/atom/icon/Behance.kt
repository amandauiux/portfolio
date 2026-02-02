package com.amandabicalho.portfolio.core.designsystem.components.atom.icon

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.svg.Circle
import com.varabyte.kobweb.compose.dom.svg.Path
import com.varabyte.kobweb.compose.dom.svg.Svg
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun Behance(
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
        Circle {
            cx(24)
            cy(24.667)
            r(20)
            fill(Color.argb(0xFFD9480F))
        }
        Circle {
            cx(22)
            cy(22.333)
            r(19.5)
            stroke(Color.argb(0xFF141414))
        }
        Path {
            d(
                "M21.3438 23.2578C22.5195 23.5859 23.0938 24.4883 23.0938 25.6914C23.0938 27.6602 21.4531 28.5078 19.6758 28.5078H15V18.8281H19.5664C21.207 18.8281 22.6562 19.293 22.6562 21.2344C22.6562 22.1914 22.1914 22.8203 21.3438 23.2578ZM17.1055 20.4688V22.7383H19.2656C20.0312 22.7383 20.5781 22.4102 20.5781 21.5898C20.5781 20.6875 19.8945 20.4688 19.1289 20.4688H17.1055ZM19.4023 26.8672C20.25 26.8672 20.9609 26.5664 20.9609 25.582C20.9609 24.5977 20.3867 24.1875 19.4297 24.1875H17.1055V26.8672H19.4023ZM29.1914 20.2773V19.3203H25.2812V20.2773H29.1914ZM30.75 25.1172C30.75 25.2266 30.7227 25.3633 30.7227 25.4727H25.6641C25.6641 26.5938 26.2656 27.25 27.3867 27.25C27.9609 27.25 28.7266 26.9492 28.918 26.3477H30.6133C30.0938 27.9336 29 28.6992 27.332 28.6992C25.1172 28.6992 23.7227 27.1953 23.7227 25.0078C23.7227 22.9023 25.1719 21.2891 27.332 21.2891C29.5195 21.2891 30.75 23.0391 30.75 25.1172ZM25.6641 24.2422H28.8086C28.7266 23.3125 28.2344 22.7656 27.25 22.7656C26.3477 22.7656 25.7188 23.3398 25.6641 24.2422Z",
            )
            fill(Color.argb(0xFF000000))
        }
    }
}
