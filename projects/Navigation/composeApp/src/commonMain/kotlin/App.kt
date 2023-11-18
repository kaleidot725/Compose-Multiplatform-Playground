import Mode.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class Mode {
    PRECOMPOSE,
    VOYAGER,
    DECOMPOSE,
}

@Composable
fun App() {
    var mode by remember { mutableStateOf(PRECOMPOSE) }
    MaterialTheme {
        Column {
            when (mode) {
                PRECOMPOSE -> {
                    Box(
                        modifier = Modifier.weight(1.0f).fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("PRECOMPOSE SCREEN")
                    }
                }

                VOYAGER -> {
                    Box(
                        modifier = Modifier.weight(1.0f).fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("VOYAGER SCREEN")
                    }
                }

                DECOMPOSE -> {
                    Box(
                        modifier = Modifier.weight(1.0f).fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("DECOMPOSE SCREEN")
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