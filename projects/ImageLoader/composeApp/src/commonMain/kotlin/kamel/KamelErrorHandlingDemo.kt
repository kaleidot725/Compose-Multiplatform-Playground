package kamel

import ImageResource
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.kamel.core.Resource
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun KamelErrorHandlingDemo() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        when (val resource = asyncPainterResource(data = ImageResource.sampleImage)) {
            is Resource.Success -> {
                Image(
                    painter = resource.value,
                    contentDescription = "sample",
                    modifier = Modifier.size(200.dp)
                )
            }

            is Resource.Loading -> {
                Image(
                    painter = painterResource(ImageResource.placeholder),
                    contentDescription = "placeholder",
                    modifier = Modifier.size(200.dp)
                )
            }

            is Resource.Failure -> {
                Image(
                    painter = painterResource(ImageResource.error),
                    contentDescription = "placeholder",
                    modifier = Modifier.size(200.dp)
                )
            }
        }
    }
}