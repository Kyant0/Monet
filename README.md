# Monet

[![JitPack Release](https://jitpack.io/v/Kyant0/Monet.svg)](https://jitpack.io/#Kyant0/Monet)

**A Jetpack Compose library that creates your own Material3 palettes**

[Interactive demo](https://Kyant0.github.io/Monet)

## Usages

```kotlin
// pick a key color
val color = Color.Blue

// generate tonal palettes with Vibrant style
val palettes = color.toHct().generateTonalPalettes(style = PaletteStyle.Vibrant)

// generate Compose Material3 color scheme
val colorScheme = palettes.toColorScheme()

// in your Theme.kt
MaterialTheme(colorScheme = colorScheme) {
    // primary color, use as normal
    MaterialTheme.colorScheme.primary
}
```

Get more customizable:

```kotlin
// Don't limit to the default M3 palettes, use them in your own way
CompositionLocalProvider(LocalTonalPalettes provides palettes) {
    40.a1 withNight 80.a1
}
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
    implementation("com.github.Kyant0:Monet:<TAG>")
}
```
