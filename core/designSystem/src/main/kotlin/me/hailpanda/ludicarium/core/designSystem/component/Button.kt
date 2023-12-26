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
import androidx.compose.material3.FilledIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.hailpanda.ludicarium.core.designSystem.icon.LudicariumIcon
import me.hailpanda.ludicarium.core.designSystem.theme.LudicariumTheme

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
        shape = MaterialTheme.shapes.medium,
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
        shape = MaterialTheme.shapes.medium,
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
 * A toggle button with icon and checked icon content slots. Wraps Material 3 [IconButton].
 *
 * @param checked Whether the toggle button is currently checked.
 * @param onCheckedChange Called when the user clicks the toggle button and toggles checked.
 * @param modifier Modifier to be applied to the toggle button.
 * @param enabled Controls the enabled state of the toggle button. When `false`, this toggle button
 * will not be clickable and will appear disabled to accessibility services.
 * @param icon The icon content to show when unchecked.
 * @param checkedIcon The icon content to show when checked.
 */
@Composable
fun LudicariumIconToggleButton(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: @Composable () -> Unit,
    checkedIcon: @Composable () -> Unit = icon,
) {
    // TODO: File bug
    // Can't use regular IconToggleButton as it doesn't include a shape (appears square)
    FilledIconToggleButton(
        checked = checked,
        onCheckedChange = onCheckedChange,
        modifier = modifier,
        enabled = enabled,
        colors = IconButtonDefaults.iconToggleButtonColors(
            checkedContainerColor = MaterialTheme.colorScheme.primary,
            checkedContentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = if (checked) {
                MaterialTheme.colorScheme.onBackground.copy(
                    alpha = LudicariumButtonDefaults.DISABLED_ICON_BUTTON_CONTAINER_ALPHA,
                )
            } else {
                Color.Transparent
            },
        ),
    ) {
        if (checked) checkedIcon() else icon()
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
fun ButtonPreview() {
    LudicariumTheme {
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
fun OutlinedButtonPreview() {
    LudicariumTheme {
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
fun ButtonLeadingIconPreview() {
    LudicariumTheme {
        LudicariumBackground(modifier = Modifier.size(150.dp, 50.dp,)) {
            LudicariumButton(
                onClick = {},
                text = { Text("Button") },
                leadingIcon = { Icon(imageVector = LudicariumIcon.Add, contentDescription = null) },
            )
        }
    }
}

@ThemePreviews
@Composable
fun IconButtonPreview() {
    LudicariumTheme {
        LudicariumBackground(modifier = Modifier.size(50.dp, 50.dp)) {
            LudicariumIconToggleButton(
                checked = true,
                onCheckedChange = { },
                icon = {
                    Icon(
                        imageVector = LudicariumIcon.BookmarkBorder,
                        contentDescription = null,
                    )
                },
                checkedIcon = {
                    Icon(
                        imageVector = LudicariumIcon.Bookmark,
                        contentDescription = null,
                    )
                },
            )
        }
    }
}

@ThemePreviews
@Composable
fun IconButtonUncheckedPreview() {
    LudicariumTheme {
        LudicariumBackground(modifier = Modifier.size(50.dp, 50.dp)) {
            LudicariumIconToggleButton(
                checked = false,
                onCheckedChange = { },
                icon = {
                    Icon(
                        imageVector = LudicariumIcon.BookmarkBorder,
                        contentDescription = null,
                    )
                },
                checkedIcon = {
                    Icon(
                        imageVector = LudicariumIcon.Bookmark,
                        contentDescription = null,
                    )
                },
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
    // IconToggleButton disabled container alpha not exposed by IconButtonDefaults
    const val DISABLED_ICON_BUTTON_CONTAINER_ALPHA = 0.12f

    // TODO: File bug
    // OutlinedButton default border width isn't exposed via ButtonDefaults
    val OutlinedButtonBorderWidth = 1.dp
}
