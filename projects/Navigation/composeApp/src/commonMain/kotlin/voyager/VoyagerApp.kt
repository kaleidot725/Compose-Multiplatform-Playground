package voyager

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import voyager.screen.GalleryScreen

@Composable
fun VoyagerApp() {
    Navigator(GalleryScreen())
}