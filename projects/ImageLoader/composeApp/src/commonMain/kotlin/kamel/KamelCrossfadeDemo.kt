package kamel

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun KamelCrossfadeDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        KamelImage(
            resource = asyncPainterResource(data = Resource.sampleImage),
            contentDescription = "sample",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp),
            animationSpec = tween(durationMillis = 2000),
            onLoading = {
                Image(
                    painter = painterResource(Resource.placeholder),
                    contentDescription = null,
                    modifier = Modifier.size(500.dp)
                )
            },
            onFailure = {
                Image(
                    painter = painterResource(Resource.error),
                    contentDescription = null,
                    modifier = Modifier.size(500.dp)
                )
            }
        )
        KamelImage(
            resource = asyncPainterResource(data = Resource.sampleErrorImage),
            contentDescription = "sample",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(200.dp),
            animationSpec = tween(durationMillis = 2000),
            onLoading = {
                Image(
                    painter = painterResource(Resource.placeholder),
                    contentDescription = null,
                    modifier = Modifier.size(500.dp)
                )
            },
            onFailure = {
                Image(
                    painter = painterResource(Resource.error),
                    contentDescription = null,
                    modifier = Modifier.size(500.dp)
                )
            }
        )
    }
}