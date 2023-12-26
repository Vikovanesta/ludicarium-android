package me.hailpanda.ludicarium.core.designSystem.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.hailpanda.ludicarium.core.designSystem.theme.LudicariumTheme

@Composable
fun LudicariumLoadingWheel(
    size: Dp = 32.dp, // indicator size
    sweepAngle: Float = 90f, // lenght of indicator arc
    color: Color = MaterialTheme.colorScheme.primary, // color of indicator arc line
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,  //width of cicle and ar lines
    contentDesc: String, // for accessibility
) {
    ////// animation //////

    // use transition animation for infinite loops
    val transition = rememberInfiniteTransition(label = "wheel transition")

    // define the changing value from 0 to 360.
    // This is the angle of the beginning of indicator arc
    // this value will change over time from 0 to 360 and repeat indefinitely.
    // it changes starting position of the indicator arc and the animation is obtained
    val currentArcStartAngle by transition.animateValue(
        0,
        360,
        Int.VectorConverter,
        infiniteRepeatable(
            animation = tween(
                durationMillis = 1100,
                easing = LinearEasing
            )
        ), label = "wheel angle"
    )

    ////// draw /////

    // define stroke with given width and arc ends type considering device DPI
    val stroke = with(LocalDensity.current) {
        Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Square)
    }

    // draw on canvas
    Canvas(
        Modifier
            .size(size) // canvas size
            .padding(strokeWidth / 2) //padding. otherwise, not the whole circle will fit in the canvas
            .semantics {contentDescription = contentDesc } // for accessibility
            .testTag("LoadingWheel"),
    ) {
        // draw "background" (gray) circle with defined stroke.
        // without explicit center and radius it fit canvas bounds
        drawCircle(Color.LightGray, style = stroke)

        // draw arc with the same stroke
        drawArc(
            color,
            // arc start angle
            startAngle = currentArcStartAngle.toFloat() - 90,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = stroke
        )
    }
}

@ThemePreviews
@Composable
fun LoadingWheelPreview() {
    LudicariumTheme {
        Surface {
            LudicariumLoadingWheel(contentDesc = "LoadingWheel")
        }
    }
}
