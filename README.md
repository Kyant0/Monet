# Monet

[![JitPack Release](https://jitpack.io/v/Kyant0/Monet.svg)](https://jitpack.io/#Kyant0/Monet)

**A Jetpack Compose library that creates your own Material3 palettes**

[Interactive demo](https://Kyant0.github.io/Monet)

Compose version: 1.3.0-beta02

## Usages

```kotlin
// Obtain a key color
val color = Color.Blue

// Generate tonal palettes with TonalSpot (default) style
val palettes = color.toTonalPalettes(style = PaletteStyle.TonalSpot)

// In your Theme.kt
CompositionLocalProvider(LocalTonalPalettes provides palettes) {
    // Map TonalPalettes to Compose Material3 ColorScheme
    val colorScheme = dynamicColorScheme()

    MaterialTheme(colorScheme = colorScheme) {
        // Primary color, use as normal
        MaterialTheme.colorScheme.primary
    }
}
```

Get more customizable:

```kotlin
// Don't limit to the default M3 palettes, use color mappings in your own way
40.a1 withNight 80.a1
```

Low-level APIs:

```kotlin
val rgb = Srgb(0.5, 0.5, 0.5)
rgb.toCam16()
// ...
```

### Supported styles

- Tonal spot (default)
- Spritz (muted)
- Vibrant
- Expressive
- Rainbow
- Fruit salad
- Content

## Import library (Gradle)

```kotlin
repositories {
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Kyant0:Monet:<version>")
}
```
