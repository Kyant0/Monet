@file:JvmName("RunMonetDesktop")

package me.heizi.monet.demo.desktop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.window.singleWindowApplication
import com.kyant.monet.demo.common.App
import com.kyant.monet.demo.common.MonetTheme
import com.kyant.monet.demo.common.AppViewModel

fun main() = singleWindowApplication {
    with (remember {
        AppViewModel()
    }) {
        MonetTheme {
            App()
        }
    }
}