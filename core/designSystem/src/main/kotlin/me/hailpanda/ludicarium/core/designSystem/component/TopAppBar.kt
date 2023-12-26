package me.hailpanda.ludicarium.core.designSystem.component

import androidx.annotation.StringRes
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.hailpanda.ludicarium.core.designSystem.icon.LudicariumIcon

/**
 * A top app bar with a centered title and navigation and action icons.
 *
 * @param titleRes The string resource ID for the title.
 * @param navigationIcon The navigation icon to be rendered.
 * @param navigationIconContentDescription The content description for the navigation icon.
 * @param actionIcon The action icon to be rendered.
 * @param actionIconContentDescription The content description for the action icon.
 * @param modifier Modifier to be applied to the top app bar.
 * @param colors The colors to be used for the top app bar.
 * @param onNavigationClick The callback to be invoked when the navigation icon is clicked.
 * @param onActionClick The callback to be invoked when the action icon is clicked.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LudicariumTopAppBar(
    @StringRes titleRes: Int,
    navigationIcon: ImageVector,
    navigationIconContentDescription: String,
    actionIcon: ImageVector,
    actionIconContentDescription: String,
    modifier: Modifier = Modifier,
    colors: TopAppBarColors = TopAppBarDefaults.centerAlignedTopAppBarColors(),
    onNavigationClick: () -> Unit = {},
    onActionClick: () -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = { Text(text = stringResource(id = titleRes)) },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = navigationIcon,
                    contentDescription = navigationIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        actions = {
            IconButton(onClick = onActionClick) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionIconContentDescription,
                    tint = MaterialTheme.colorScheme.onSurface,
                )
            }
        },
        colors = colors,
        modifier = modifier.testTag("LudicariumTopAppBar"),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview("Top App Bar")
@Composable
private fun TopAppBarPreview() {
    LudicariumTopAppBar(
        titleRes = android.R.string.untitled,
        navigationIcon = LudicariumIcon.Search,
        navigationIconContentDescription = "Navigation icon",
        actionIcon = LudicariumIcon.MoreVert,
        actionIconContentDescription = "Action icon",
    )
}