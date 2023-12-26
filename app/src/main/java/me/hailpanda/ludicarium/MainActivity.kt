package me.hailpanda.ludicarium

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumButton
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumFilterChip
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumIconToggleButton
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumLoadingWheel
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumNavigationBar
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumNavigationBarItem
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumOutlinedButton
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumTab
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumTabRow
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumTag
import me.hailpanda.ludicarium.core.designSystem.component.LudicariumTextButton
import me.hailpanda.ludicarium.core.designSystem.icon.LudicariumIcon
import me.hailpanda.ludicarium.core.designSystem.theme.LudicariumTheme

@OptIn(ExperimentalLayoutApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LudicariumTheme(darkTheme = false) {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val contentPadding = WindowInsets.systemBars
                        .add(WindowInsets(left = 16.dp, top = 16.dp, right = 16.dp, bottom = 16.dp))
                        .asPaddingValues()
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = contentPadding,
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        item {
                            Text(
                                text = "Ludicarium",
                                style = MaterialTheme.typography.headlineSmall,
                            )
                        }
                        item { Text("Buttons", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                LudicariumButton(onClick = {}) {
                                    Text(text = "Enabled")
                                }
                                LudicariumOutlinedButton(onClick = {}) {
                                    Text(text = "Enabled")
                                }
                                LudicariumTextButton(onClick = {}) {
                                    Text(text = "Enabled")
                                }
                            }
                        }
                        item { Text("Disabled buttons", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                LudicariumButton(
                                    onClick = {},
                                    enabled = false,
                                ) {
                                    Text(text = "Disabled")
                                }
                                LudicariumOutlinedButton(
                                    onClick = {},
                                    enabled = false,
                                ) {
                                    Text(text = "Disabled")
                                }
                                LudicariumTextButton(
                                    onClick = {},
                                    enabled = false,
                                ) {
                                    Text(text = "Disabled")
                                }
                            }
                        }
                        item { Text("Buttons with leading icons", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                LudicariumButton(
                                    onClick = {},
                                    text = { Text(text = "Enabled") },
                                    leadingIcon = {
                                        Icon(imageVector = LudicariumIcon.Add, contentDescription = null)
                                    },
                                )
                                LudicariumOutlinedButton(
                                    onClick = {},
                                    text = { Text(text = "Enabled") },
                                    leadingIcon = {
                                        Icon(imageVector = LudicariumIcon.Add, contentDescription = null)
                                    },
                                )
                                LudicariumTextButton(
                                    onClick = {},
                                    text = { Text(text = "Enabled") },
                                    leadingIcon = {
                                        Icon(imageVector = LudicariumIcon.Add, contentDescription = null)
                                    },
                                )
                            }
                        }
                        item { Text("Disabled buttons with leading icons", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                LudicariumButton(
                                    onClick = {},
                                    enabled = false,
                                    text = { Text(text = "Disabled") },
                                    leadingIcon = {
                                        Icon(imageVector = LudicariumIcon.Add, contentDescription = null)
                                    },
                                )
                                LudicariumOutlinedButton(
                                    onClick = {},
                                    enabled = false,
                                    text = { Text(text = "Disabled") },
                                    leadingIcon = {
                                        Icon(imageVector = LudicariumIcon.Add, contentDescription = null)
                                    },
                                )
                                LudicariumTextButton(
                                    onClick = {},
                                    enabled = false,
                                    text = { Text(text = "Disabled") },
                                    leadingIcon = {
                                        Icon(imageVector = LudicariumIcon.Add, contentDescription = null)
                                    },
                                )
                            }
                        }
                        item { Text("Chips", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                var firstChecked by rememberSaveable { mutableStateOf(false) }
                                LudicariumFilterChip(
                                    selected = firstChecked,
                                    onSelectedChange = { checked -> firstChecked = checked },
                                    label = { Text(text = "Enabled") },
                                )
                                var secondChecked by rememberSaveable { mutableStateOf(true) }
                                LudicariumFilterChip(
                                    selected = secondChecked,
                                    onSelectedChange = { checked -> secondChecked = checked },
                                    label = { Text(text = "Enabled") },
                                )
                                LudicariumFilterChip(
                                    selected = false,
                                    onSelectedChange = {},
                                    enabled = false,
                                    label = { Text(text = "Disabled") },
                                )
                                LudicariumFilterChip(
                                    selected = true,
                                    onSelectedChange = {},
                                    enabled = false,
                                    label = { Text(text = "Disabled") },
                                )
                            }
                        }
                        item { Text("Tags", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                LudicariumTag(onClick = {}) {
                                    Text(text = "Shooter")
                                }
                                LudicariumTag(onClick = {}) {
                                    Text(text = "RPG")
                                }
                                LudicariumTag(onClick = {}) {
                                    Text(text = "Action")
                                }
                            }
                        }
                        item { Text("Icon buttons", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                var firstChecked by rememberSaveable { mutableStateOf(false) }
                                LudicariumIconToggleButton(
                                    checked = firstChecked,
                                    onCheckedChange = { checked -> firstChecked = checked },
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
                                var secondChecked by rememberSaveable { mutableStateOf(true) }
                                LudicariumIconToggleButton(
                                    checked = secondChecked,
                                    onCheckedChange = { checked -> secondChecked = checked },
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
                                LudicariumIconToggleButton(
                                    checked = false,
                                    onCheckedChange = {},
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
                                    enabled = false,
                                )
                                LudicariumIconToggleButton(
                                    checked = true,
                                    onCheckedChange = {},
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
                                    enabled = false,
                                )
                            }
                        }
                        item { Text("Loading Wheel", Modifier.padding(top = 16.dp)) }
                        item {
                            FlowRow(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                                LudicariumLoadingWheel(contentDesc = "LoadingWheel")
                            }
                        }
                        item { Text("Tabs", Modifier.padding(top = 16.dp)) }
                        item {
                            var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }
                            val titles = listOf("Tab1", "Tab999")
                            LudicariumTabRow(selectedTabIndex = selectedTabIndex) {
                                titles.forEachIndexed { index, title ->
                                    LudicariumTab(
                                        selected = selectedTabIndex == index,
                                        onClick = { selectedTabIndex = index },
                                        text = { Text(text = title) },
                                    )
                                }
                            }
                        }
                        item { Text("Navigation", Modifier.padding(top = 16.dp)) }
                        item {
                            var selectedItem by rememberSaveable { mutableIntStateOf(0) }
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
                                        selected = selectedItem == index,
                                        onClick = { selectedItem = index },
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}