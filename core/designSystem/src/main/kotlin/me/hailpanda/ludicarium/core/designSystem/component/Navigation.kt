package me.hailpanda.ludicarium.core.designSystem.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.hailpanda.ludicarium.core.designSystem.icon.LudicariumIcon
import me.hailpanda.ludicarium.core.designSystem.theme.LudicariumTheme

/**
 * Navigation bar item with icon and label content slots. Wraps Material 3
 * [NavigationBarItem].
 *
 * @param selected Whether this item is selected.
 * @param onClick The callback to be invoked when this item is selected.
 * @param icon The item icon content.
 * @param modifier Modifier to be applied to this item.
 * @param selectedIcon The item icon content when selected.
 * @param enabled controls the enabled state of this item. When `false`, this item will not be
 * clickable and will appear disabled to accessibility services.
 * @param label The item text label content.
 * @param alwaysShowLabel Whether to always show the label for this item. If false, the label will
 * only be shown when this item is selected.
 */
@Composable
fun RowScope.LudicariumNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = LudicariumNavigationDefaults.navigationSelectedIconColor(),
            unselectedIconColor = LudicariumNavigationDefaults.navigationContentColor(),
            selectedTextColor = LudicariumNavigationDefaults.navigationSelectedTextColor(),
            unselectedTextColor = LudicariumNavigationDefaults.navigationContentColor(),
            indicatorColor = LudicariumNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

/**
 * Navigation bar with content slot. Wraps Material 3 [NavigationBar].
 *
 * @param modifier Modifier to be applied to the navigation bar.
 * @param content Destinations inside the navigation bar. This should contain multiple
 * [NavigationBarItem]s.
 */
@Composable
fun LudicariumNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit,
) {
    NavigationBar(
        modifier = modifier,
        contentColor = LudicariumNavigationDefaults.navigationContentColor(),
        containerColor = MaterialTheme.colorScheme.background,
        tonalElevation = 0.dp,
        content = content,
    )
}

/**
 * Navigation rail item with icon and label content slots. Wraps Material 3
 * [NavigationRailItem].
 *
 * @param selected Whether this item is selected.
 * @param onClick The callback to be invoked when this item is selected.
 * @param icon The item icon content.
 * @param modifier Modifier to be applied to this item.
 * @param selectedIcon The item icon content when selected.
 * @param enabled controls the enabled state of this item. When `false`, this item will not be
 * clickable and will appear disabled to accessibility services.
 * @param label The item text label content.
 * @param alwaysShowLabel Whether to always show the label for this item. If false, the label will
 * only be shown when this item is selected.
 */
@Composable
fun LudicariumNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true,
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = LudicariumNavigationDefaults.navigationSelectedIconColor(),
            unselectedIconColor = LudicariumNavigationDefaults.navigationContentColor(),
            selectedTextColor = LudicariumNavigationDefaults.navigationSelectedTextColor(),
            unselectedTextColor = LudicariumNavigationDefaults.navigationContentColor(),
            indicatorColor = LudicariumNavigationDefaults.navigationIndicatorColor(),
        ),
    )
}

/**
 * Navigation rail with header and content slots. Wraps Material 3 [NavigationRail].
 *
 * @param modifier Modifier to be applied to the navigation rail.
 * @param header Optional header that may hold a floating action button or a logo.
 * @param content Destinations inside the navigation rail. This should contain multiple
 * [NavigationRailItem]s.
 */
@Composable
fun LudicariumNavigationRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = LudicariumNavigationDefaults.navigationContentColor(),
        header = header,
        content = content,
    )
}

@ThemePreviews
@Composable
fun NavigationPreview() {
    val items = listOf("Home", "Saved", "Interests")
    val icons = listOf(
        LudicariumIcon.HomeBorder,
        LudicariumIcon.BookmarksBorder,
        LudicariumIcon.Grid3x3,
    )
    val selectedIcons = listOf(
        LudicariumIcon.Home,
        LudicariumIcon.Bookmarks,
        LudicariumIcon.Grid3x3,
    )

    LudicariumTheme {
        LudicariumNavigationBar {
            items.forEachIndexed { index, item ->
                LudicariumNavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = icons[index],
                            contentDescription = item,
                        )
                    },
                    selectedIcon = {
                        Icon(
                            imageVector = selectedIcons[index],
                            contentDescription = item,
                        )
                    },
                    label = { Text(item) },
                    selected = index == 0,
                    onClick = { },
                )
            }
        }
    }
}

/**
 * Navigation default values.
 */
object LudicariumNavigationDefaults {
    @Composable
    fun navigationContentColor() = MaterialTheme.colorScheme.onBackground

    @Composable
    fun navigationSelectedIconColor() = MaterialTheme.colorScheme.onPrimary

    @Composable
    fun navigationSelectedTextColor() = MaterialTheme.colorScheme.onBackground

    @Composable
    fun navigationIndicatorColor() = MaterialTheme.colorScheme.primary
}