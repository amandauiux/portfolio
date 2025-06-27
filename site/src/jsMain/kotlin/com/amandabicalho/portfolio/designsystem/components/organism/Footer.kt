package com.amandabicalho.portfolio.components.sections

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.designsystem.components.atom.button.TextButton
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.LinkedIn
import com.amandabicalho.portfolio.core.designsystem.components.atom.icon.Logo
import com.amandabicalho.portfolio.core.extensions.padding
import com.amandabicalho.portfolio.core.foundation.layout.PaddingValues
import com.amandabicalho.portfolio.core.ui.theme.Theme
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.amandabicalho.portfolio.designsystem.components.atom.Text
import com.varabyte.kobweb.compose.css.Background
import com.varabyte.kobweb.compose.css.BackgroundImage
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.url
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.alignSelf
import com.varabyte.kobweb.compose.ui.modifiers.background
import com.varabyte.kobweb.compose.ui.modifiers.borderBottom
import com.varabyte.kobweb.compose.ui.modifiers.borderTop
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.AlignSelf
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.dom.Footer

object FooterVars {
    val BorderColor by StyleVariable<Color>()
}

val FooterStyle = CssStyle.base {
    Modifier
        .background(
            Background.of(image = BackgroundImage.of(url("images/bg_footer.svg"))),
            Background.of(
                image = BackgroundImage.of(
                    gradient = linearGradient(angle = 270.deg) {
                        add(Color.argb(0xFFFFFCF7), 24.37.percent)
                        add(Color.rgba(255, 255, 255, 0), 45.88.percent)
                        add(Color.rgba(255, 255, 255, 0), 56.25.percent)
                        add(Color.argb(0xFFFFFFFF), 78.28.percent)
                    },
                ),
            ),
        )
        .borderTop {
            width(1.dp)
            color(FooterVars.BorderColor.value())
            style(LineStyle.Solid)
        }
}

@Composable
fun Footer(modifier: Modifier = Modifier) {
    Footer(
        attrs = FooterStyle
            .toModifier()
            .then(modifier)
            .setVariable(FooterVars.BorderColor, Theme.colorScheme.primary[30])
            .toAttrs(),
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(40.dp)
                    .borderBottom {
                        width(1.dp)
                        color(FooterVars.BorderColor.value())
                        style(LineStyle.Solid)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                ) {
                    Logo(modifier = Modifier.size(50.dp))
                    Text(
                        text = "Have a project idea? Drop me a message at email@email.com",
                        style = Theme.typography.titleLarge,
                        modifier = Modifier.maxWidth(410.dp),
                    )
                }
                Column(
                    verticalArrangement = Arrangement.spacedBy(20.dp),
                    modifier = Modifier.alignSelf(AlignSelf.FlexEnd),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        LinkedIn()
                        Text(
                            text = "LinkedIn",
                            style = Theme.typography.bodySmall,
                            modifier = Modifier.padding(start = 8.dp),
                        )
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                    ) {
                        FooterNavigationTextButton(
                            text = "Work",
                            onClick = { /* TODO: Add navigation */ },
                        )
                        FooterNavigationTextButton(
                            text = "About",
                            onClick = { /* TODO: Add navigation */ },
                        )
                        FooterNavigationTextButton(
                            text = "Contact",
                            onClick = { /* TODO: Add navigation */ },
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp, vertical = 20.dp),
            ) {
                Text(
                    text = "Designed by Amanda, coded by Rafael with love",
                    style = Theme.typography.bodySmall.copy(
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                    ),
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
    }
}

@Composable
private fun FooterNavigationTextButton(text: String, onClick: () -> Unit) {
    TextButton(
        onClick = onClick,
        contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp),
    ) {
        Text(
            text = text,
            style = Theme.typography.bodyMedium,
        )
    }
}
