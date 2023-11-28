package kamel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private enum class KamelDemoType {
    IMAGE,
    LOADING,
    ERROR,
    PLACE_HOLDER,
    CROSSFADE,
    ERROR_HANDLING,
}

@Composable
fun KamelDemo() {
    var type: KamelDemoType? by remember { mutableStateOf(null) }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = KamelDemoType.entries) {
                Button(
                    onClick = { type = it },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(it.name)
                }
            }
        }

        if (type != null) {
            Box(modifier = Modifier.fillMaxSize()) {
                when (type) {
                    KamelDemoType.IMAGE -> KamelImageDemo()
                    KamelDemoType.LOADING -> KamelLoadingDemo()
                    KamelDemoType.ERROR -> KamelErrorDemo()
                    KamelDemoType.PLACE_HOLDER -> KamelPlaceHolderDemo()
                    KamelDemoType.CROSSFADE -> KamelCrossfadeDemo()
                    KamelDemoType.ERROR_HANDLING -> KamelErrorHandlingDemo()
                    null -> {}
                }

                Button(
                    onClick = { type = null },
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Text("Close")
                }
            }
        }
    }
}

