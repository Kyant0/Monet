package com.kyant.monetdemo

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.kyant.monet.demo.common.App
import com.kyant.monet.demo.common.AppViewModel
import com.kyant.monet.demo.common.MonetTheme

class MainActivity : ComponentActivity() {
    private val viewModel: AppViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setContent {
            with(viewModel) {
                MonetTheme {
                    App()
                }
            }
        }
    }
}
