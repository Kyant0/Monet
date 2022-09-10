package com.kyant.monet.demo.common

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color


expect class AppViewModel {
    var color: Color?
    var selectedStyle: Int
}
