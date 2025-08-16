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
import org.w3c.dom.HTMLMetaElement

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

private const val DEFAULT_DESCRIPTION =
    "Explore my UX UI design portfolio featuring a curated collection of design projects and " +
        "insightful case studies. Discover my approach and expertise as a designer."

class PageLayoutData(
    val title: String,
    val thumbnail: String = "favicon-32x32.png",
    val description: String = DEFAULT_DESCRIPTION,
    val keywords: List<String> = emptyList(),
)

@Composable
@Layout
fun PageLayout(context: PageContext, content: @Composable ColumnScope.() -> Unit) {
    val data = context.data.getValue<PageLayoutData>()
    var colorMode by ColorMode.currentState
    LaunchedEffect(data.title) {
        data.title.let { title ->
            document.title = "$title | Amanda Bicalho Portfolio"
            createOrUpdateMetaTag(name = "title", content = title)
            createOrUpdateMetaTag(name = "og:title", content = title)
            createOrUpdateMetaTag(name = "twitter:title", content = title)
        }
        data.thumbnail.let { thumbnail ->
            val url = if (thumbnail.startsWith("https://") || thumbnail.startsWith("http://")) {
                thumbnail
            } else {
                "https://amandauiux.github.io/portfolio/$thumbnail"
            }
            createOrUpdateMetaTag(name = "og:image", content = url)
            createOrUpdateMetaTag(name = "twitter:image", content = url)
            createOrUpdateMetaTag(name = "twitter:card", content = "summary_large_image")
        }
        data.description.let { description ->
            createOrUpdateMetaTag(name = "description", content = description)
            createOrUpdateMetaTag(name = "og:description", content = description)
            createOrUpdateMetaTag(name = "twitter:description", content = description)
        }
        if (data.keywords.isNotEmpty()) {
            createOrUpdateMetaTag(
                name = "keywords",
                content = data.keywords.joinToString(", "),
            )
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

private fun createOrUpdateMetaTag(name: String, content: String) {
    document.head?.let { head ->
        val metaTag = (head.querySelector("meta[name='$name']")
            ?: document.createElement("meta")) as HTMLMetaElement
        metaTag.name = name
        metaTag.content = content
        head.appendChild(metaTag)
    }
}
