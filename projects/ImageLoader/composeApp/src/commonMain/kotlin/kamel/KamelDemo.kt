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
import io.kamel.core.config.DefaultCacheSize
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.httpFetcher
import io.kamel.core.config.takeFrom
import io.kamel.core.utils.cacheControl
import io.kamel.image.config.Default
import io.kamel.image.config.LocalKamelConfig
import io.kamel.image.config.imageBitmapDecoder
import io.kamel.image.config.imageVectorDecoder
import io.kamel.image.config.svgDecoder
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.request
import io.ktor.http.CacheControl

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
    val customKamelConfig by remember {
        mutableStateOf(
            KamelConfig {
                takeFrom(KamelConfig.Default)
                svgCacheSize = 0
                imageBitmapCacheSize = 0
                imageVectorCacheSize = 0
                httpFetcher {
                    request {
                        cacheControl(CacheControl.MaxAge(0))
                    }
                }
            }
        )
    }

    CompositionLocalProvider(LocalKamelConfig provides customKamelConfig) {
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
}

