package voyager.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import common.content.GalleryContent
import common.resource.Pictures

class GalleryScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        GalleryContent(
            pictures = Pictures.value,
            onClick = { navigator?.push(PreviewScreen(it)) },
            modifier = Modifier.fillMaxSize()
        )
    }
}