package kamel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import io.kamel.image.config.LocalKamelConfig

@Composable
fun KamelLoadingDemo() {
    val kamelConfig = LocalKamelConfig.current
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        KamelImage(
            resource = asyncPainterResource(Resource.sampleImage),
            contentDescription = "sample",
            modifier = Modifier.fillMaxSize(),
            onLoading = { CircularProgressIndicator(modifier = Modifier.size(128.dp)) }
        )
    }
}