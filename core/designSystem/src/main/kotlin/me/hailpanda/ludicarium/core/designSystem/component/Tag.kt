package me.hailpanda.ludicarium.core.designSystem.component

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import me.hailpanda.ludicarium.core.designSystem.theme.LudicariumTheme

/**
 * A tag for topics.
 *
 * @param modifier Modifier to be applied to the tag.
 * @param onClick The callback to be invoked when this tag is clicked.
 * @param enabled Controls the enabled state of the tag. When `false`, this tag will not be
 * clickable and will appear disabled to accessibility services.
 * @param text The text label content.
 */
@Composable
fun LudicariumTag(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    text: @Composable () -> Unit,
) {
    Box(modifier = modifier) {
        val containerColor = MaterialTheme.colorScheme.secondary

        TextButton(
            onClick = onClick,
            enabled = enabled,
            colors = ButtonDefaults.textButtonColors(
                containerColor = containerColor,
                contentColor = contentColorFor(backgroundColor = containerColor),
                disabledContainerColor = MaterialTheme.colorScheme.onSurface.copy(
                    alpha = LudicariumTagDefaults.DISABLED_TOPIC_TAG_CONTAINER_ALPHA,
                ),
            ),
        ) {
            ProvideTextStyle(value = MaterialTheme.typography.labelSmall) {
                text()
            }
        }
    }
}

@ThemePreviews
@Composable
fun TagPreview() {
    LudicariumTheme {
        LudicariumTag(onClick = {}) {
            Text("Topic".uppercase())
        }
    }
}

/**
 * Now in Android tag default values.
 */
object LudicariumTagDefaults {
    const val UNFOLLOWED_TOPIC_TAG_CONTAINER_ALPHA = 0.5f

    // TODO: File bug
    // Button disabled container alpha value not exposed by ButtonDefaults
    const val DISABLED_TOPIC_TAG_CONTAINER_ALPHA = 0.12f
}