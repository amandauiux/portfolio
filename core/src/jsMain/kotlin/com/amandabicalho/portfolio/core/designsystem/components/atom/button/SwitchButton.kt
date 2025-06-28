package com.amandabicalho.portfolio.core.designsystem.components.atom.button

import androidx.compose.runtime.Composable
import com.amandabicalho.portfolio.core.ui.unit.Dp
import com.amandabicalho.portfolio.core.ui.unit.dp
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.setVariable
import com.varabyte.kobweb.silk.components.forms.Switch
import com.varabyte.kobweb.silk.components.forms.SwitchVars
import org.jetbrains.compose.web.css.div
import org.jetbrains.compose.web.css.minus
import org.jetbrains.compose.web.css.percent

object SwitchButtonVars {
    val ThumbOutlineTranslationX by StyleVariable<Dp>()
    val ThumbOutlineTranslationY by StyleVariable<Dp>()
    val ThumbOffset by StyleVariable<CSSLengthOrPercentageNumericValue>(0.percent)
}

@Composable
fun SwitchButton(
    checked: Boolean,
    onCheckChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckChange,
        modifier = modifier
            .setVariable(SwitchVars.TrackWidth, 50.dp)
            .setVariable(SwitchVars.TrackHeight, 25.dp)
            .setVariable(
                variable = SwitchButtonVars.ThumbOffset,
                value = if (checked) {
                    (SwitchVars.TrackWidth.value() - (SwitchVars.TrackWidth.value() / 2) - 1.85.dp)
                } else {
                    0.percent
                },
            )
            .then(
                if (checked) {
                    Modifier
                        .setVariable(variable = SwitchButtonVars.ThumbOutlineTranslationX, value = 1.5.dp)
                        .setVariable(variable = SwitchButtonVars.ThumbOutlineTranslationY, value = (-1).dp)
                } else {
                    Modifier
                        .setVariable(variable = SwitchButtonVars.ThumbOutlineTranslationX, value = (-1.5).dp)
                        .setVariable(variable = SwitchButtonVars.ThumbOutlineTranslationY, value = (-1).dp)
                }
            ),
    )
}
