package com.example.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = Color.White,

    secondary = Green40,
    onSecondary = Color.White,

    error = Red40,
    onError = Color.White,

    background = GrayLight,
    onBackground = Color.Black,

    surface = Color.White,
    onSurface = Color.Black,

    surfaceVariant = Color(0xFFE5E7EB),
    onSurfaceVariant = Color(0xFF374151),

    outline = Color(0xFFCBD5E1),
    scrim = Color.Black
)

private val DarkColorScheme = darkColorScheme(
    primary = Blue80,
    onPrimary = Color.Black,

    secondary = Green80,
    onSecondary = Color.Black,

    error = Red80,
    onError = Color.Black,

    background = GrayDark,
    onBackground = Color.White,

    surface = Color(0xFF1E1E1E),
    onSurface = Color.White,

    surfaceVariant = Color(0xFF2A2A2A),
    onSurfaceVariant = Color(0xFFD1D5DB),

    outline = Color(0xFF4B5563),
    scrim = Color.Black
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}
