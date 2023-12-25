package me.hailpanda.ludicarium.core.designSystem.theme

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

/**
 * Light default theme color scheme
 */
@VisibleForTesting
val LightDefaultColorScheme = lightColorScheme(
    primary = Gold70,
    onPrimary = Gold90,
    primaryContainer = Gold40,
    onPrimaryContainer = Gold90,
    secondary = LightSalmon70,
    onSecondary = LightSalmon90,
    secondaryContainer = LightSalmon40,
    onSecondaryContainer = LightSalmon90,
    tertiary = Mindaro80,
    onTertiary = Mindaro10,
    tertiaryContainer = Mindaro40,
    onTertiaryContainer = Mindaro90,
    error = Red80,
    onError = Red10,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Gold90,
    onBackground = Gold40,
    surface = Gray90,
    onSurface = Gray10,
    surfaceVariant = Gray30,
    onSurfaceVariant = Gray80,
    inverseSurface = Gray10,
    inverseOnSurface = Gray90,
    outline = Gray40,
)

/**
 * Dark default theme color scheme
 */
@VisibleForTesting
val DarkDefaultColorScheme = darkColorScheme(
    primary = Gold80,
    onPrimary = Gold10,
    primaryContainer = Gold30,
    onPrimaryContainer = Gold90,
    secondary = LightSalmon80,
    onSecondary = LightSalmon10,
    secondaryContainer = LightSalmon30,
    onSecondaryContainer = LightSalmon90,
    tertiary = Mindaro80,
    onTertiary = Mindaro10,
    tertiaryContainer = Mindaro30,
    onTertiaryContainer = Mindaro90,
    error = Red80,
    onError = Red10,
    errorContainer = Red30,
    onErrorContainer = Red90,
    background = Gray10,
    onBackground = Gray90,
    surface = Gray10,
    onSurface = Gray90,
    surfaceVariant = Gray80,
    onSurfaceVariant = Gray30,
    inverseSurface = Gray90,
    inverseOnSurface = Gray10,
    outline = Gray40,
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    disableDynamicTheming: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        !disableDynamicTheming && supportDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        else -> if (darkTheme) DarkDefaultColorScheme else LightDefaultColorScheme
    }

    val emptyGradientColors = GradientColor(container = colorScheme.surfaceColorAtElevation(2.dp))
    val defaultGradientColors = GradientColor(
        top = colorScheme.inverseOnSurface,
        bottom = colorScheme.primaryContainer,
        container = colorScheme.surface
    )
    val gradientColors = when {
        !disableDynamicTheming && supportDynamicTheming() -> emptyGradientColors
        else -> defaultGradientColors
    }

    val backgroundTheme = BackgroundTheme(
        color = colorScheme.surface,
        tonalElevation = 2.dp,
    )
    val tintTheme = when {
        !disableDynamicTheming && supportDynamicTheming() -> TintTheme(colorScheme.primary)
        else -> TintTheme()
    }

    CompositionLocalProvider(
        LocalGradientColor provides gradientColors,
        LocalBackgroundTheme provides backgroundTheme,
        LocalTintTheme provides tintTheme,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content,
        )
    }

}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
