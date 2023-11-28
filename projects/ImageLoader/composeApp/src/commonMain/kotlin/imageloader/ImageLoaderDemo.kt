package imageloader

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

private enum class ImageLoaderDemoType {
    IMAGE,
    LOADING,
    ERROR,
    PLACE_HOLDER,
    CROSSFADE,
    ERROR_HANDLING,
}

@Composable
fun ImageLoaderDemo() {
    var type: ImageLoaderDemoType? by remember { mutableStateOf(null) }
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(items = ImageLoaderDemoType.entries) {
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
                    ImageLoaderDemoType.IMAGE -> ImageLoaderImageDemo()
                    ImageLoaderDemoType.LOADING -> ImageLoaderLoadingDemo()
                    ImageLoaderDemoType.ERROR -> ImageLoaderErrorDemo()
                    ImageLoaderDemoType.PLACE_HOLDER -> ImageLoaderPlaceHolderDemo()
                    ImageLoaderDemoType.CROSSFADE -> ImageLoaderCrossfadeDemo()
                    ImageLoaderDemoType.ERROR_HANDLING -> ImageLoaderErrorHandlingDemo()
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

