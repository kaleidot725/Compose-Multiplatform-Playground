package imageloader

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.rememberImagePainter
import com.seiko.imageloader.ui.AutoSizeImage

@Composable
fun ImageLoaderImageDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        AutoSizeImage(
            url = ImageResource.sampleImage,
            contentDescription = "sample",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp)
        )
    }
}