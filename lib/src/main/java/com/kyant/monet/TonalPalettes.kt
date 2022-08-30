package com.kyant.monet

import com.kyant.monet.Cam16.Companion.toCam16

public typealias TonalPalette = Map<Double, Srgb>

public class TonalPalettes(
    public val keyColor: Srgb,
    public val style: PaletteStyle = PaletteStyle.TonalSpot,
    private val accent1: TonalPalette,
    private val accent2: TonalPalette,
    private val accent3: TonalPalette,
    private val neutral1: TonalPalette,
    private val neutral2: TonalPalette
) {
    public infix fun accent1(tone: Double): Srgb = accent1.getOrElse(tone) {
        keyColor.transform(tone, style.accent1Spec)
    }

    public infix fun accent2(tone: Double): Srgb = accent2.getOrElse(tone) {
        keyColor.transform(tone, style.accent2Spec)
    }

    public infix fun accent3(tone: Double): Srgb = accent3.getOrElse(tone) {
        keyColor.transform(tone, style.accent3Spec)
    }

    public infix fun neutral1(tone: Double): Srgb = neutral1.getOrElse(tone) {
        keyColor.transform(tone, style.neutral1Spec)
    }

    public infix fun neutral2(tone: Double): Srgb = neutral2.getOrElse(tone) {
        keyColor.transform(tone, style.neutral2Spec)
    }

    public companion object {
        private val M3TonalValues = doubleArrayOf(
            0.0, 10.0, 20.0, 30.0, 40.0, 50.0, 60.0, 70.0, 80.0, 85.0, 90.0, 95.0, 99.0, 100.0
        )

        public fun Srgb.toTonalPalettes(
            style: PaletteStyle = PaletteStyle.TonalSpot,
            tonalValues: DoubleArray = M3TonalValues
        ): TonalPalettes {
            return TonalPalettes(
                keyColor = this,
                style = style,
                accent1 = tonalValues.associateWith { transform(it, style.accent1Spec) },
                accent2 = tonalValues.associateWith { transform(it, style.accent2Spec) },
                accent3 = tonalValues.associateWith { transform(it, style.accent3Spec) },
                neutral1 = tonalValues.associateWith { transform(it, style.neutral1Spec) },
                neutral2 = tonalValues.associateWith { transform(it, style.neutral2Spec) }
            )
        }

        private fun Srgb.transform(tone: Double, spec: ColorSpec): Srgb {
            val cam = toCieXyz().toCam16()
            return Hct(
                h = cam.h + spec.hueShift(cam.h),
                c = (
                    if (tone >= 90.0) spec.chroma(cam.c).coerceAtMost(40.0)
                    else spec.chroma(cam.c)
                    ) * 2.0 / 3.0,
                t = tone
            ).toSrgb()
        }
    }
}
