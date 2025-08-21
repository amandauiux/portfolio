package com.amandabicalho.portfolio.components.template

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.components.template.project.OtherProjectsSection
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.domain.Projects
import com.amandabicalho.portfolio.ui.theme.DesktopTypography
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.PageContext
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.cssRule
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobwebx.markdown.markdown
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Div

val MarkdownStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(40.dp)
            .fillMaxSize()
            .padding(vertical = 40.dp, horizontal = 16.dp)
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }

    Breakpoint.MD {
        Modifier
            .gap(80.dp)
            .padding(vertical = 80.dp, horizontal = 36.dp)
    }
    cssRule(Breakpoint.MD, "h1") {
        DesktopTypography.headlineMedium.toModifier()
    }
    cssRule(Breakpoint.MD, "h2") {
        DesktopTypography.headlineSmall.toModifier()
    }
    cssRule(Breakpoint.MD, "h3") {
        DesktopTypography.titleLarge.toModifier()
    }
    cssRule(Breakpoint.MD, "h4") {
        DesktopTypography.titleMedium.toModifier()
    }
    cssRule(Breakpoint.MD, "h5") {
        DesktopTypography.titleSmall.toModifier()
    }
    cssRule(Breakpoint.MD, "h6") {
        DesktopTypography.titleSmall.toModifier()
    }

    cssRule("img") {
        Modifier.width(100.percent)
    }

    cssRule("ul > li") {
        Modifier.margin(left = 16.dp)
    }
}

@InitRoute
fun initMarkdownLayout(ctx: InitRouteContext) {
    val frontMatter = ctx.markdown?.frontMatter ?: error("Markdown file must set frontmatter")
    val title = requireNotNull(frontMatter["title"]?.singleOrNull()) {
        "Markdown file must set \"title\" in frontmatter"
    }
    val description = requireNotNull(frontMatter["description"]?.singleOrNull()) {
        "Markdown file must set \"description\" in frontmatter"
    }
    val thumbnail = requireNotNull(frontMatter["thumbnail"]?.singleOrNull()) {
        "Markdown file must set \"thumbnail\" in frontmatter"
    }
    val tags = frontMatter["tags"]?.takeIf { it.isNotEmpty() }.orEmpty()
    ctx.data.add(
        PageLayoutData(
            title = title,
            description = description,
            thumbnail = thumbnail,
            keywords = tags,
        )
    )
}

@Composable
@Layout(".components.template.PageLayout")
fun MarkdownLayout(
    context: PageContext,
    content: @Composable () -> Unit,
) {
    Div(MarkdownStyle.toAttrs()) {
        content()

        OtherProjectsSection(
            projects = Projects
                .entries
                .filterNot { it.route in context.route.path }
                .sortedByDescending { it.publishedAt },
            onProjectClick = { context.router.navigateTo(it.route) },
        )
    }
}
