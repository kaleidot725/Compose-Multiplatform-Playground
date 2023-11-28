package imageloader

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.model.ImageRequest
import com.seiko.imageloader.rememberImagePainter
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox
import com.seiko.imageloader.ui.AutoSizeImage

@Composable
fun ImageLoaderLoadingDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        AutoSizeBox(
            url = ImageResource.sampleImage
        ) { action ->
            when (action) {
                is ImageAction.Success -> {
                    Image(
                        rememberImageSuccessPainter(action),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(200.dp)
                    )
                }

                is ImageAction.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(128.dp)
                    )
                }

                else -> {}
            }
        }
    }
}