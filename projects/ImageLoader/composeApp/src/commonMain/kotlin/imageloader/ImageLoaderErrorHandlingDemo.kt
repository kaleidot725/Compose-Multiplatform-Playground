package imageloader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ImageResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageLoaderErrorHandlingDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        AutoSizeBox(url = ImageResource.sampleImage) { action ->
            when (action) {
                is ImageAction.Success -> {
                    Image(
                        painter = rememberImageSuccessPainter(action),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(200.dp)
                    )
                }

                is ImageAction.Loading -> {
                    Image(
                        painter = painterResource(ImageResource.placeholder),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(200.dp)
                    )
                }

                is ImageAction.Failure -> {
                    Image(
                        painter = painterResource(ImageResource.error),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.size(200.dp)
                    )
                }

                else -> {}
            }
        }
    }
}