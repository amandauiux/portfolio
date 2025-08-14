package com.amandabicalho.portfolio.components.template.showcase

import Res
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.amandabicalho.portfolio.colorScheme
import com.amandabicalho.portfolio.components.atom.Text
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridDefaults
import com.amandabicalho.portfolio.core.designsystem.components.atom.content.GridSection
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexDirection
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.gridColumn
import com.varabyte.kobweb.compose.ui.modifiers.gridRow
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateAreas
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateColumns
import com.varabyte.kobweb.compose.ui.modifiers.gridTemplateRows
import com.varabyte.kobweb.compose.ui.modifiers.rowGap
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.cssRule
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobwebx.markdown.markdown
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexDirection
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.fr
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.H1

val ShowcaseHeaderContainerStyle = CssStyle {
    base {
        Modifier
            .rowGap(20.dp)
            .padding(bottom = 40.dp)
            .borderBottom {
                width(1.dp)
                style(LineStyle.Solid)
                color(colorScheme.primary[30])
            }
    }
    Breakpoint.LG {
        Modifier.rowGap(80.dp)
    }
}

val ShowcaseHeaderTitleContainerStyle = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
            .gap(20.dp)
    }

    Breakpoint.MD {
        Modifier.gap(20.dp)
    }
}

val ShowcaseHeaderTitleStyle = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
            .color(colorScheme.primary[30])
    }
}

val ShowcaseHeaderHeroImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
}

val ShowcaseHeaderProjectInfoContainerStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .gap(20.dp)
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }

    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Row)
    }
}

val ShowcaseHeaderProjectInfoGridStyle = CssStyle {
    base {
        Modifier
            .display(DisplayStyle.Flex)
            .flexDirection(FlexDirection.Column)
            .rowGap(20.dp)
    }

    Breakpoint.MD {
        Modifier
            .display(DisplayStyle.Grid)
            .gridTemplateColumns {
                repeat(6) { size(1.fr) }
            }
            .gridTemplateAreas(GridDefaults.calculateGridTemplateAreas(areaSize = 6))
            .gridTemplateRows {
                repeat(4) { size(1.fr) }
            }
    }

    cssRule(Breakpoint.MD, "> div:nth-child(odd)") {
        Modifier.gridColumn("span 2")
    }

    cssRule(Breakpoint.MD, "> div:nth-child(even)") {
        Modifier.gridColumn("span 3")
    }
}

val ShowcaseHeaderProjectInfoStyle = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }
}

val ShowcaseHeaderProjectInfoCol2Style = CssStyle {
    base {
        Modifier
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
    }

    Breakpoint.MD {
        Modifier.gridColumn(start = 3, end = 5)
    }
}

val ShowcaseHeaderProjectBackgroundStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .gridColumn(start = GridDefaults.LEFT_AREA, end = GridDefaults.RIGHT_AREA)
            .gap(12.dp)
    }

    Breakpoint.MD {
        Modifier
            .gridColumn(start = 7, end = 13)
            .gridRow(start = 2, end = 4)
            .gap(16.dp)
    }
}

val ShowcaseHeaderProjectBackgroundContentStyle = CssStyle {
    base {
        Modifier.gap(16.dp)
    }
}

@Composable
fun ShowcaseHeader(
    heroImageUrl: String? = null,
    content: @Composable () -> Unit,
) {
    val context = rememberPageContext()
    val markdown = remember(context) {
        context.markdown ?: error("ShowcaseHeader must be used within a markdown context")
    }
    val title = remember(markdown.frontMatter) {
        markdown
            .frontMatter["title"]
            ?.singleOrNull()
            ?: error("Markdown file must set \"title\" in frontmatter")
    }
    val team = remember(markdown.frontMatter) {
        markdown
            .frontMatter["team"]
            ?.singleOrNull()
    }
    val client = remember(markdown.frontMatter) {
        markdown
            .frontMatter["client"]
            ?.singleOrNull()
    }
    val year = remember(markdown.frontMatter) {
        markdown
            .frontMatter["year"]
            ?.singleOrNull()
            ?: error("Markdown file must set \"year\" in frontmatter")
    }
    val projectType = remember(markdown.frontMatter) {
        markdown
            .frontMatter["project_type"]
            ?.takeIf { it.isNotEmpty() }
            ?.joinToString()
            ?: error("Markdown file must set \"project_type\" in frontmatter")
    }
    val industry = remember(markdown.frontMatter) {
        markdown
            .frontMatter["industry"]
            ?.takeIf { it.isNotEmpty() }
            ?.joinToString()
            ?: error("Markdown file must set \"industry\" in frontmatter")
    }
    val tags = remember(markdown.frontMatter) {
        markdown
            .frontMatter["tags"]
            ?.takeIf { it.isNotEmpty() }
            ?: error("Markdown file must set \"tags\" in frontmatter")
    }
    val thumbnailUrl = remember(markdown.frontMatter) {
        markdown
            .frontMatter["thumbnail"]
            ?.singleOrNull()
            ?: error("Markdown file must set \"thumbnail\" in frontmatter")
    }
    Column(
        modifier = ShowcaseHeaderContainerStyle.toModifier(),
    ) {
        GridSection(modifier = ShowcaseHeaderTitleContainerStyle.toModifier()) {
            H1(
                attrs = ShowcaseHeaderTitleStyle.toAttrs(),
            ) {
                org.jetbrains.compose.web.dom.Text(value = title)
            }
            Image(
                src = heroImageUrl ?: thumbnailUrl,
                alt = "Hero Image",
                modifier = ShowcaseHeaderHeroImageStyle.toModifier(),
            )
        }

        Div(attrs = ShowcaseHeaderProjectInfoContainerStyle.toAttrs()) {
            GridSection(modifier = ShowcaseHeaderProjectInfoGridStyle.toModifier()) {
                client?.let { client ->
                    ProjectInfo(
                        title = Res.string.showcase_project_info_client,
                        value = client,
                        modifier = ShowcaseHeaderProjectInfoStyle.toModifier(),
                    )
                }
                team?.let { team ->
                    ProjectInfo(
                        title = Res.string.showcase_project_info_team,
                        value = team,
                        modifier = ShowcaseHeaderProjectInfoStyle.toModifier(),
                    )
                }
                ProjectInfo(
                    title = Res.string.showcase_project_info_year_duration,
                    value = year,
                    modifier = ShowcaseHeaderProjectInfoStyle.toModifier(),
                )
                ProjectInfo(
                    title = Res.string.showcase_project_info_project_type,
                    value = projectType,
                    modifier = ShowcaseHeaderProjectInfoStyle.toModifier(),
                )
                ProjectInfo(
                    title = Res.string.showcase_project_info_industry,
                    value = industry,
                    modifier = ShowcaseHeaderProjectInfoStyle.toModifier(),
                )
            }
            Column(
                modifier = ShowcaseHeaderProjectBackgroundStyle.toModifier(),
            ) {
                Text(
                    text = Res.string.showcase_project_background,
                    style = Theme.typography.titleLarge,
                )

                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    content()
                }
            }
        }
    }
}


@Composable
private fun ProjectInfo(
    title: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = title,
            style = Theme.typography.titleSmall,
        )
        Text(
            text = value,
            style = Theme.typography.bodyMedium,
        )
    }
}
