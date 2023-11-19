package voyager.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import common.content.GalleryContent
import common.resource.Picture
import common.resource.Pictures

class GalleryScreenModel : ScreenModel {
    val pictures: List<Picture> = Pictures.value
}

class GalleryScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val screenModel = rememberScreenModel { GalleryScreenModel() }
        GalleryContent(
            pictures = screenModel.pictures,
            onClick = { navigator?.push(PreviewScreen(it)) },
            modifier = Modifier.fillMaxSize()
        )
    }
}