package com.amandabicalho.portfolio.components.template

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.typography.toModifier
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.core.ui.unit.sp
import com.amandabicalho.portfolio.ui.theme.Typography
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.width
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
        Typography.headlineMedium.copy(
            fontSize = 80.sp,
            lineHeight = 96.sp,
        ).toModifier()
    }
    cssRule(Breakpoint.MD, "h2") {
        Typography.headlineSmall.copy(
            fontSize = 60.sp,
            lineHeight = 72.sp,
        ).toModifier()
    }
    cssRule(Breakpoint.MD, "h3") {
        Typography.titleLarge.copy(
            fontSize = 36.sp,
            lineHeight = 46.8.sp,
        ).toModifier()
    }
    cssRule(Breakpoint.MD, "h4") {
        Typography.titleMedium.copy(
            fontSize = 32.sp,
            lineHeight = 41.6.sp,
        ).toModifier()
    }
    cssRule(Breakpoint.MD, "h5") {
        Typography.titleSmall.copy(
            fontSize = 24.sp,
            lineHeight = 31.2.sp,
        ).toModifier()
    }
    cssRule(Breakpoint.MD, "h6") {
        Typography.titleSmall.copy(
            fontSize = 24.sp,
            lineHeight = 31.2.sp,
        ).toModifier()
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
    val title = requireNotNull(ctx.markdown?.frontMatter["title"]?.singleOrNull()) {
        "Markdown file must set \"title\" in frontmatter"
    }
    val description = requireNotNull(ctx.markdown?.frontMatter["description"]?.singleOrNull()) {
        "Markdown file must set \"description\" in frontmatter"
    }
    ctx.data.add(
        PageLayoutData(title = title, description = description)
    )
}

@Composable
@Layout(".components.template.PageLayout")
fun MarkdownLayout(content: @Composable () -> Unit) {
    Div(MarkdownStyle.toAttrs()) {
        content()
    }
}
