package com.kyant.monetdemo

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.kyant.monet.LocalTonalPalettes
import com.kyant.monet.PaletteStyle
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import com.kyant.monet.n1

@Composable
fun AppViewModel.MonetTheme(content: @Composable () -> Unit) {
    val baseColor = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        colorResource(id = android.R.color.system_accent1_500)
    } else Color(0xFF007FAC)
    val keyColor = color ?: baseColor
    MaterialTheme {
        CompositionLocalProvider(
            LocalTonalPalettes provides keyColor.toTonalPalettes(
                style = when (selectedStyle) {
                    0 -> PaletteStyle.TonalSpot
                    1 -> PaletteStyle.Spritz
                    2 -> PaletteStyle.Vibrant
                    3 -> PaletteStyle.Expressive
                    4 -> PaletteStyle.Rainbow
                    5 -> PaletteStyle.FruitSalad
                    else -> error("")
                }
            ),
            LocalContentColor provides if (isSystemInDarkTheme()) 100.n1 else 0.n1
        ) {
            content()
        }
    }
}
