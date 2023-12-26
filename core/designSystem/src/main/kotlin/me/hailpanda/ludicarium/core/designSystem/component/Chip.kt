package me.hailpanda.ludicarium.core.designSystem.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.hailpanda.ludicarium.core.designSystem.icon.LudicariumIcon
import me.hailpanda.ludicarium.core.designSystem.theme.LudicariumTheme

/**
 * Ludicarium filter chip with included leading checked icon as well as text content slot.
 *
 * @param selected Whether the chip is currently checked.
 * @param onSelectedChange Called when the user clicks the chip and toggles checked.
 * @param modifier Modifier to be applied to the chip.
 * @param enabled Controls the enabled state of the chip. When `false`, this chip will not be
 * clickable and will appear disabled to accessibility services.
 * @param label The text label content.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun LudicariumFilterChip(
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    label: @Composable () -> Unit,
) {
    FilterChip(
        selected = selected,
        onClick = { onSelectedChange(!selected) },
        label = {
            ProvideTextStyle(value = MaterialTheme.typography.labelSmall) {
                label()
            }
        },
        modifier = modifier,
        enabled = enabled,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = LudicariumIcon.Check,
                    contentDescription = null,
                )
            }
        } else {
            null
        },
        shape = CircleShape,
        border = FilterChipDefaults.filterChipBorder(
            borderColor = MaterialTheme.colorScheme.secondary,
            selectedBorderColor = MaterialTheme.colorScheme.secondary,
            disabledBorderColor = MaterialTheme.colorScheme.secondary.copy(
                alpha = LudicariumChipDefaults.DISABLED_CHIP_CONTENT_ALPHA,
            ),
            disabledSelectedBorderColor = MaterialTheme.colorScheme.secondary.copy(
                alpha = LudicariumChipDefaults.DISABLED_CHIP_CONTENT_ALPHA,
            ),
            selectedBorderWidth = LudicariumChipDefaults.ChipBorderWidth,
        ),
        colors = FilterChipDefaults.filterChipColors(
            labelColor = MaterialTheme.colorScheme.secondary,
            iconColor = MaterialTheme.colorScheme.secondary,
            disabledContainerColor = if (selected) {
                MaterialTheme.colorScheme.secondary.copy(
                    alpha = LudicariumChipDefaults.DISABLED_CHIP_CONTAINER_ALPHA,
                )
            } else {
                Color.Transparent
            },
            disabledLabelColor = MaterialTheme.colorScheme.secondary.copy(
                alpha = LudicariumChipDefaults.DISABLED_CHIP_CONTENT_ALPHA,
            ),
            disabledLeadingIconColor = MaterialTheme.colorScheme.secondary.copy(
                alpha = LudicariumChipDefaults.DISABLED_CHIP_CONTENT_ALPHA,
            ),
            selectedContainerColor = MaterialTheme.colorScheme.secondary,
            selectedLabelColor = MaterialTheme.colorScheme.onSecondary,
            selectedLeadingIconColor = MaterialTheme.colorScheme.onSecondary,
        ),
    )
}

@ThemePreviews
@Composable
fun ChipPreview() {
    LudicariumTheme {
        LudicariumBackground(modifier = Modifier.size(80.dp, 20.dp)) {
            LudicariumFilterChip(selected = true, onSelectedChange = {}) {
                Text(text = "Chip")
            }
        }
    }
}

object LudicariumChipDefaults {
    // TODO: File bug
    // FilterChip default values aren't exposed via FilterChipDefaults
    const val DISABLED_CHIP_CONTAINER_ALPHA = 0.12f
    const val DISABLED_CHIP_CONTENT_ALPHA = 0.38f
    val ChipBorderWidth = 1.dp
}