package com.example.elaborato_mobile.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = GreenPrimaryDark,
    secondary = GreenSecondaryDark,
    background = GreenBackgroundDark,
    surface = GreenCardBackgroundDark,
    onPrimary = Color.Black,
    onSecondary = Color.Black,
    onBackground = GreenTextPrimaryDark,
    onSurface = GreenTextSecondaryDark,
    error = RedErrorDark,
    onError = Color.Black
)

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    onPrimary = Color.White, // White text on primary blue for contrast

    secondary = BlueSecondary,
    onSecondary = Color.White, // White text for secondary elements

    background = BackgroundLight,
    onBackground = TextPrimary, // Dark text on the light background

    surface = SurfaceBackground,
    onSurface = TextPrimary,   // Primary text on white surface

    error = ErrorRed,
    onError = Color.White,  // White text on error red background

    // Additional colors
    surfaceVariant = SurfaceBackground,      // White surface for cards
    onSurfaceVariant = TextPrimary, // Dark text color for text on surface variants

    outline = DisabledGrey, // Muted grey outline for borders

    // Disabled elements
    onTertiary = DisabledGrey,          // Muted grey for disabled elements
    onPrimaryContainer = IconAccent      // Orange accent icons for visibility
)

@Composable
fun Elaborato_MobileTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}