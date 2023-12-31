import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App() {
    MaterialTheme {
Row (
    modifier = Modifier.fillMaxWidth(),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.spacedBy(16.dp)
) {
    Image(
        painter  = painterResource("PNG.png"),
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )

    Image(
        painter = painterResource("JPG.jpg"),
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )

    Image(
        painter = painterResource("WEBP.webp"),
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )

    Image(
        painter = painterResource("SVG.xml"),
        contentDescription = null,
        modifier = Modifier.size(100.dp)
    )
}
    }
}
