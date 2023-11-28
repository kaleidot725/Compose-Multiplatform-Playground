package imageloader

import ImageResource
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.ui.AutoSizeImage
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ImageLoaderErrorDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        AutoSizeImage(
            url = ImageResource.sampleErrorImage,
            contentDescription = "sample",
            contentScale = ContentScale.Crop,
            errorPainter = { painterResource(ImageResource.error) },
            modifier = Modifier.size(200.dp)
        )
    }
}