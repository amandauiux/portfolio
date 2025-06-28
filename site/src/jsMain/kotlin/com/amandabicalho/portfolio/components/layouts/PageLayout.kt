package com.amandabicalho.portfolio.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.amandabicalho.portfolio.components.sections.Footer
import com.amandabicalho.portfolio.designsystem.components.organism.NavHeader
import com.amandabicalho.portfolio.core.designsystem.components.organism.SideBar
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.ColumnScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxHeight
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.zIndex
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.data.getValue
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.CssStyle
import kotlinx.browser.document
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.vh

val PageContentStyle = CssStyle {
    base { Modifier.fillMaxSize().padding(start = 2.dp, top = 4.dp) }
}

class PageLayoutData(val title: String)

@Composable
@Layout
fun PageLayout(ctx: PageContext, content: @Composable ColumnScope.() -> Unit) {
    val data = ctx.data.getValue<PageLayoutData>()
    LaunchedEffect(data.title) {
        document.title = "${data.title} | Amanda Bicalho Portfolio"
    }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .minHeight(100.vh)
            .gridTemplateColumns {
                size(80.dp) // Sidebar takes up 80px
                size(1.fr) // Main content area takes up all available space
            }
            .gridTemplateRows {
                size(1.fr) // Main content area takes up all available space
                size(minContent) // Footer takes up only as much space as it needs
            }
    ) {
        SideBar(
            modifier = Modifier
                .gridRow(start = 1, end = "last-line")
                .gridColumn(1)
                .fillMaxHeight()
                .zIndex(1),
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .gridRow(1)
                .gridColumn(2),
        ) {
            NavHeader()
            content()
        }
        Footer(
            modifier = Modifier
                .fillMaxWidth()
                .gridRow(2)
                .gridColumn(2),
        )
    }

//    Box(
//        Modifier
//            .fillMaxWidth()
//            .minHeight(100.vh)
//            // Create a box with two rows: the main content (fills as much space as it can) and the footer (which reserves
//            // space at the bottom). "min-content" means the use the height of the row, which we use for the footer.
//            // Since this box is set to *at least* 100%, the footer will always appear at least on the bottom but can be
//            // pushed further down if the first row grows beyond the page.
//            // Grids are powerful but have a bit of a learning curve. For more info, see:
//            // https://css-tricks.com/snippets/css/complete-guide-grid/
//            .gridTemplateRows {
//                size(1.fr)
//                size(minContent)
//            },
//        contentAlignment = Alignment.Center
//    ) {
//        Row {
//            SideBar()
//            Column(
//                // Isolate the content, because otherwise the absolute-positioned SVG above will render on top of it.
//                // This is confusing but how browsers work. Read up on stacking contexts for more info.
//                // https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_positioned_layout/Understanding_z-index/Stacking_context
//                // Some people might have used z-index instead, but best practice is to avoid that if possible, because
//                // as a site gets complex, Z-fighting can be a huge pain to track down.
//                Modifier.fillMaxSize().gridRow(1),
//                horizontalAlignment = Alignment.CenterHorizontally,
//            ) {
//                NavHeader()
//                Div(PageContentStyle.toAttrs()) {
//                    content()
//                }
//            }
//        }
//        // Associate the footer with the row that will get pushed off the bottom of the page if it can't fit.
//        Footer(modifier = Modifier.fillMaxWidth().gridRow(2))
//    }
}
