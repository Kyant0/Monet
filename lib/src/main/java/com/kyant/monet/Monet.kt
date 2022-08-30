@file:Suppress("unused")

package com.kyant.monet

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import com.kyant.monet.TonalPalettes.Companion.toTonalPalettes
import kotlin.math.roundToInt

public val LocalTonalPalettes: CompositionLocal<TonalPalettes> = staticCompositionLocalOf {
    Color(0xFF007FAC).toSrgb().toTonalPalettes()
}

public inline val Number.a1: Color
    @Composable get() = (LocalTonalPalettes.current accent1 toDouble()).toColor()

public inline val Number.a2: Color
    @Composable get() = (LocalTonalPalettes.current accent2 toDouble()).toColor()

public inline val Number.a3: Color
    @Composable get() = (LocalTonalPalettes.current accent3 toDouble()).toColor()

public inline val Number.n1: Color
    @Composable get() = (LocalTonalPalettes.current neutral1 toDouble()).toColor()

public inline val Number.n2: Color
    @Composable get() = (LocalTonalPalettes.current neutral2 toDouble()).toColor()

@Composable
public infix fun Color.withNight(nightColor: Color): Color {
    return if (isSystemInDarkTheme()) nightColor else this
}

public fun Srgb.toColor(): Color {
    return Color(
        (r * 255).roundToInt(),
        (g * 255).roundToInt(),
        (b * 255).roundToInt()
    )
}

public fun Color.toSrgb(): Srgb {
    return Srgb(
        red.toDouble(),
        green.toDouble(),
        blue.toDouble()
    )
}
