package com.amandabicalho.portfolio.components.template

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.amandabicalho.portfolio.components.organism.Footer
import com.amandabicalho.portfolio.components.organism.NavHeader
import com.amandabicalho.portfolio.core.designsystem.components.organism.SideBar
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
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import kotlinx.browser.document
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.css.vh

val PageContainerStyle = CssStyle {
    base {
        Modifier
            .fillMaxHeight()
            .minHeight(100.vh)
            .gridTemplateRows {
                size(1.fr) // Main content area takes up all available space
                size(minContent) // Footer takes up only as much space as it needs
            }
    }
    Breakpoint.MD {
        Modifier
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
    }
}

val PageSideBarStyle = CssStyle {
    base {
        Modifier
            .gridRow(start = 1, end = 1)
            .gridColumn(1)
            .zIndex(1)
    }
    Breakpoint.MD {
        Modifier
            .gridRow(start = 1, end = "last-line")
            .gridColumn(1)
            .fillMaxHeight()
            .zIndex(1)
    }
}

val PageContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxSize()
            .gridRow(1)
            .gridColumn(2)
    }
}

val PageFooterStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gridRow(2)
            .gridColumn(2)
    }
}

class PageLayoutData(
    val title: String,
    val description: String? = null,
)

@Composable
@Layout
fun PageLayout(context: PageContext, content: @Composable ColumnScope.() -> Unit) {
    val data = context.data.getValue<PageLayoutData>()
    var colorMode by ColorMode.currentState
    LaunchedEffect(data.title) {
        document.title = "${data.title} | Amanda Bicalho Portfolio"
        data.description?.let { description ->
            document
                .querySelector(selectors = "meta[name='description']")
                ?.setAttribute(qualifiedName = "content", value = description)
        }
    }

    Box(
        modifier = PageContainerStyle.toModifier(),
    ) {
        SideBar(modifier = PageSideBarStyle.toModifier())
        Column(modifier = PageContentStyle.toModifier()) {
            NavHeader(
                isDark = colorMode.isDark,
                onLogoClick = { context.router.navigateTo("/") },
                onProjectsClick = { context.router.navigateTo("/projects") },
                onAboutClick = { context.router.navigateTo("/about") },
                onThemeToggleClick = { colorMode = colorMode.opposite },
            )
            content()
        }
        Footer(
            onProjectsClick = { context.router.navigateTo("/projects") },
            onAboutClick = { context.router.navigateTo("/about") },
            modifier = PageFooterStyle.toModifier(),
        )
    }
}
