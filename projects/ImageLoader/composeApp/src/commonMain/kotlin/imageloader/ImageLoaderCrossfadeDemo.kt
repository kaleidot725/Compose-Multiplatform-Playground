package imageloader

import ImageResource
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.seiko.imageloader.model.ImageAction
import com.seiko.imageloader.rememberImageSuccessPainter
import com.seiko.imageloader.ui.AutoSizeBox
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageLoaderCrossfadeDemo() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        AutoSizeCrossfadeImage(url = ImageResource.sampleImage)
        AutoSizeCrossfadeImage(url = ImageResource.sampleErrorImage)
    }
}

@OptIn(ExperimentalAnimationApi::class, ExperimentalResourceApi::class)
@Composable
private fun AutoSizeCrossfadeImage(
    url: String,
    modifier: Modifier = Modifier,
) {
    AutoSizeBox(
        url = url,
        modifier = modifier,
    ) { action ->
        AnimatedContent(
            targetState = action,
            transitionSpec = { fadeIn(animationSpec = tween(0)) with fadeOut(animationSpec = tween(0)) }
        ) { action ->
            when (action) {
                is ImageAction.Success -> {
                    Image(
                        painter = rememberImageSuccessPainter(action),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .animateEnterExit(
                                enter = fadeIn(),
                                exit = fadeOut(),
                            )
                    )
                }

                is ImageAction.Loading -> {
                    Image(
                        painter = painterResource(ImageResource.placeholder),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .animateEnterExit(
                                enter = fadeIn(animationSpec = tween(0)),
                                exit = fadeOut(),
                            )
                    )
                }

                is ImageAction.Failure -> {
                    Image(
                        painter = painterResource(ImageResource.error),
                        contentDescription = "image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(200.dp)
                            .animateEnterExit(
                                enter = fadeIn(),
                                exit = fadeOut(),
                            )
                    )
                }

                else -> {}
            }
        }
    }
}