package com.kyant.monet.demo.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kyant.monet.Hct
import com.kyant.monet.a1
import com.kyant.monet.a2
import com.kyant.monet.a3
import com.kyant.monet.n1
import com.kyant.monet.n2
import com.kyant.monet.toColor
import com.kyant.monet.withNight
import kotlin.random.Random


expect fun Modifier.systemBarsPadding():Modifier
expect val app_name:String

@Composable
fun AppViewModel.App() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(96.n1 withNight 10.n1)
            .verticalScroll(rememberScrollState())
            .systemBarsPadding()
            .padding(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        AppHeadline()
        ChangeKeyColor()
        StyleTabs()
        Palette()
    }
}

@Composable
private fun AppHeadline() {
    Spacer(modifier = Modifier)
    Text(
        text = app_name,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        fontWeight = FontWeight.Medium,
        style = MaterialTheme.typography.displaySmall
    )
    Spacer(modifier = Modifier)
}

@Composable
private fun AppViewModel.ChangeKeyColor() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(100.n1 withNight 30.n1)
            .clickable { color = Hct(Random.nextDouble(0.0, 360.0), 10.0, 50.0).toSrgb().toColor() }
            .padding(24.dp)
    ) {
        Text(
            text = "Tab here to change key color",
            fontWeight = FontWeight.Medium,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Composable
private fun AppViewModel.StyleTabs() {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(
            items = arrayOf("Tonal Spot", "Spritz", "Vibrant", "Expressive", "Rainbow", "Fruit Salad"),
            key = { _, name -> name }
        ) { index, name ->
            val isSelected = selectedStyle == index
            CompositionLocalProvider(
                LocalIndication provides rememberRipple(
                    color = if (isSelected) 100.n1 withNight 0.n1
                    else 0.n1 withNight 100.n1
                )
            ) {
                Text(
                    text = name,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(
                            animateColorAsState(
                                targetValue = if (isSelected) 40.a1 withNight 90.a1
                                else 92.a1 withNight 20.n1
                            ).value
                        )
                        .clickable { selectedStyle = index }
                        .padding(24.dp, 16.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = animateColorAsState(
                        targetValue = if (isSelected) 100.n1 withNight 0.n1
                        else 0.n1 withNight 100.n1
                    ).value
                )
            }
        }
    }
}

@Composable
private fun Palette() {
    val tonalValues = intArrayOf(0, 10, 20, 30, 40, 50, 60, 70, 80, 85, 90, 95, 99, 100)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(100.n1 withNight 20.n1)
            .padding(16.dp, 24.dp)
    ) {
        repeat(5) { shade ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 4.dp)
            ) {
                tonalValues.reversed().forEach { tone ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .height(40.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(
                                when (shade) {
                                    0 -> tone.a1
                                    1 -> tone.a2
                                    2 -> tone.a3
                                    3 -> tone.n1
                                    4 -> tone.n2
                                    else -> error("")
                                }
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = tone.toString(),
                            color = if (tone > 50) 0.n1 else 100.n1,
                            style = MaterialTheme.typography.titleSmall
                        )
                    }
                }
            }
        }
    }
}
