package me.hailpanda.ludicarium.core.designSystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.hailpanda.ludicarium.core.designSystem.icon.LudicariumIcon
import me.hailpanda.ludicarium.core.designSystem.theme.AppTheme

/**
 * A filled button with generic content slot. Wraps Material 3 [Button].
 *
 * @param onClick The callback to be executed when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Whether the button is enabled and can be interacted with.
 * @param contentPadding The padding to be applied to the button content.
 * @param content The button content.
 */
@Composable
fun LudicariumButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding : PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

/**
 * A filled button with text label and optional leading icon.
 *
 * @param onClick The callback to be executed when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Whether the button is enabled and can be interacted with.
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Default is `null` for no leading icon.
 */
@Composable
fun LudicariumButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    LudicariumButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
    ) {
        LudicariumButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}


/**
 * An outlined button with generic content slot. Wraps Material 3 [OutlinedButton].
 *
 * @param onClick The callback to be executed when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Whether the button is enabled and can be interacted with.
 * @param contentPadding The padding to be applied to the button content.
 * @param content The button content.
 */
@Composable
fun LudicariumOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        border = BorderStroke(
            width = LudicariumButtonDefaults.OutlinedButtonBorderWidth,
            color = if (enabled) {
                MaterialTheme.colorScheme.primary
            } else {
                MaterialTheme.colorScheme.onSurface.copy(
                    alpha = LudicariumButtonDefaults.DISABLED_OUTLINED_BUTTON_BORDER_ALPHA,
                )
            },
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

/**
 * An outlined button with text label and optional leading icon.
 *
 * @param onClick The callback to be executed when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Whether the button is enabled and can be interacted with.
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Default is `null` for no leading icon.
 */
@Composable
fun LudicariumOutlinedButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    LudicariumOutlinedButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        contentPadding = if (leadingIcon != null) {
            ButtonDefaults.ButtonWithIconContentPadding
        } else {
            ButtonDefaults.ContentPadding
        },
    ) {
        LudicariumButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}


/**
 * A text button with generic content slot. Wraps Material 3 [Button].
 *
 * @param onClick The callback to be executed when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Whether the button is enabled and can be interacted with.
 * @param content The button content.
 */
@Composable
fun LudicariumTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit,
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.primary,
        ),
        contentPadding = ButtonDefaults.TextButtonContentPadding,
        content = content,
    )
}

/**
 * A text button with text label and optional leading icon.
 *
 * @param onClick The callback to be executed when the button is clicked.
 * @param modifier Modifier to be applied to the button.
 * @param enabled Whether the button is enabled and can be interacted with.
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Default is `null` for no leading icon.
 */
@Composable
fun LudicariumTextButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    LudicariumTextButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
    ) {
        LudicariumButtonContent(
            text = text,
            leadingIcon = leadingIcon,
        )
    }
}

/**
 * Internal button content layout for arranging the text label and leading icon.
 *
 * @param text The button text label content.
 * @param leadingIcon The button leading icon content. Default is `null` for no leading icon.
 */
@Composable
private fun LudicariumButtonContent(
    text: @Composable () -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null,
) {
    if (leadingIcon != null) {
        Box(Modifier.sizeIn(maxHeight = ButtonDefaults.IconSize)) {
            leadingIcon()
        }
    }
    Box(
        Modifier
            .padding(
                start = if (leadingIcon != null) {
                    ButtonDefaults.IconSpacing
                } else {
                    0.dp
                },
            ),
    ) {
        text()
    }
}

@ThemePreviews
@Composable
fun LudicariumButtonPreview() {
    AppTheme {
        LudicariumBackground(modifier = Modifier.size(150.dp, 50.dp)) {
            LudicariumButton(
                onClick = {},
                text = { Text("Filled Button") },
            )
        }
    }
}

@ThemePreviews
@Composable
fun LudicariumOutlinedButtonPreview() {
    AppTheme {
        LudicariumBackground(modifier = Modifier.size(150.dp, 50.dp)) {
            LudicariumOutlinedButton(
                onClick = {},
                text = { Text("Outlined Button") },
            )
        }
    }
}

@ThemePreviews
@Composable
fun LudicariumButtonLeadingIconPrevies() {
    AppTheme {
        LudicariumBackground(modifier = Modifier.size(150.dp, 50.dp,)) {
            LudicariumButton(
                onClick = {},
                text = { Text("Button") },
                leadingIcon = { Icon(imageVector = LudicariumIcon.Add, contentDescription = null) },
            )
        }
    }
}

/**
 * Ludicarium button default values.
 */
object LudicariumButtonDefaults {
    // TODO: File bug
    // OutlinedButton border color doesn't respect disabled state by default
    const val DISABLED_OUTLINED_BUTTON_BORDER_ALPHA = 0.12f

    // TODO: File bug
    // OutlinedButton default border width isn't exposed via ButtonDefaults
    val OutlinedButtonBorderWidth = 1.dp
}
