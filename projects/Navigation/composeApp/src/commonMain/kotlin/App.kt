import Mode.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import decompose.DecomposeApp
import precompose.PrecomposeApp
import voyager.VoyagerApp
import androidx.compose.runtime.Composable as Composable1

enum class Mode {
    PRECOMPOSE,
    VOYAGER,
    DECOMPOSE,
}

@Composable1
fun App() {
    var mode by remember { mutableStateOf(PRECOMPOSE) }
    MaterialTheme {
        Column {
            Box(modifier = Modifier.weight(1.0f)) {
                when (mode) {
                    PRECOMPOSE -> {
                        PrecomposeApp()
                    }

                    VOYAGER -> {
                        VoyagerApp()
                    }

                    DECOMPOSE -> {
                        DecomposeApp()
                    }
                }
            }

            Divider()

            Row {
                Mode.entries.forEach {
                    Text(
                        text = it.name,
                        fontSize = 12.sp,
                        maxLines = 2,
                        color = if (mode == it) Color.Red else Color.Black,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .weight(1.0f)
                            .clickable { mode = it }
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}