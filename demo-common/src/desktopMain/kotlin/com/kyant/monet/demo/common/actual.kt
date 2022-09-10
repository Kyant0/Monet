package com.kyant.monet.demo.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


actual fun Modifier.systemBarsPadding(): Modifier
        = this
actual val app_name: String = "MonetTest-Desktop"
@Composable
actual fun baseColor():Color =
     runCatching {
         if (System.getProperty("os.name").startsWith("Windows"))
             Runtime.getRuntime().exec("cmd /c reg query HKEY_CURRENT_USER\\SOFTWARE\\Microsoft\\Windows\\DWM /v AccentColor").let { process ->
                 process.inputStream.use {
                    it.bufferedReader(charset("gbk")).readText()
                        .splitToSequence(" ","\n",)
                        .filter { it.isNotBlank() }
                        .last()
                        .let { s ->
                            Color(
                                Integer.valueOf(s.substring(8,10),16),
                                Integer.valueOf(s.substring(6,8),16),
                                Integer.valueOf(s.substring(4,6),16),
                                Integer.valueOf(s.substring(2,4),16),
                            )
                        }
                        .also {
                            process.destroy()
                        }
                }
        } else null
    }.onFailure {
         println()
         println("dynamic color dont work here: cant query the color form Windows 10 Reg")
         println(it.message)
         println(it)
     }.getOrDefault(Color(0xFF007FAC))!!

actual class AppViewModel {
    actual var color by mutableStateOf<Color?>(null)
    actual var selectedStyle by mutableStateOf(0)
}
