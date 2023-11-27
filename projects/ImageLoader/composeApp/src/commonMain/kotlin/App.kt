import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp

private enum class Mode {
    KAMEL,
    IMAGE_LOADER,
}

@Composable
fun App() {
    var mode by remember { mutableStateOf(Mode.KAMEL) }
    MaterialTheme(colors = darkColors()) {
        Surface {
            Column(modifier = Modifier.safeContentPadding()) {
                Row {
                    Mode.entries.forEach {
                        Text(
                            text = it.name,
                            fontSize = 12.sp,
                            maxLines = 2,
                            color = if (mode == it) Color.Red else Color.White,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .weight(1.0f)
                                .clickable { mode = it }
                                .padding(8.dp)
                        )
                    }
                }

                Divider()

                Box(modifier = Modifier.weight(1.0f)) {
                    when (mode) {
                        Mode.KAMEL -> {
                            Text("KAMEL")
                        }

                        Mode.IMAGE_LOADER -> {
                            Text("IMAGE_LOADER")
                        }
                    }
                }
            }
        }
    }
}