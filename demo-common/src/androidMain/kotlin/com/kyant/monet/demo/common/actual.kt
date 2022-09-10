@file:SuppressLint("mmp in alpha")

package com.kyant.monet.demo.common

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.systemBarsPadding as systemPadding
import android.app.Application
import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.AndroidViewModel
import com.kyant.monet.R



actual class AppViewModel(application: Application) : AndroidViewModel(application) {
    actual var color by mutableStateOf<Color?>(null)
    actual var selectedStyle by mutableStateOf(0)
}

actual fun Modifier.systemBarsPadding(): Modifier
        = systemPadding()

//@get:Composable
actual val app_name: String
//    get() = stringResource(id = R.string.app_name)
    = "MonetDemo"
@Composable
actual fun baseColor()
= if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
    colorResource(id = android.R.color.system_accent1_500)
} else Color(0xFF007FAC)
