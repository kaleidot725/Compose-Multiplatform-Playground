package precompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.resource.Pictures
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator
import moe.tlaster.precompose.navigation.transition.NavTransition
import precompose.screen.DetailsDialog
import precompose.screen.GalleryScreen
import precompose.screen.PreviewScreen

@Composable
fun PrecomposeApp() {
    PreComposeApp {
        val navigator = rememberNavigator()
        NavHost(
            navigator = navigator,
            navTransition = NavTransition(),
            initialRoute = "/gallery"
        ) {
            scene(
                route = "/gallery",
                navTransition = NavTransition(),
            ) {
                GalleryScreen(
                    pictures = Pictures.value,
                    onNavigatePreview = { navigator.navigate("/preview/${it.name}") },
                    modifier = Modifier.fillMaxSize()
                )
            }

            scene(
                route = "/preview/{name}",
                navTransition = NavTransition(),
            ) { backStackEntry ->
                val name = backStackEntry.path<String>("name")
                val picture = Pictures.value.firstOrNull { it.name == name } ?: return@scene

                PreviewScreen(
                    picture = picture,
                    onNavigateDetails = { navigator.navigate("/details/{name}") },
                    onBack = { navigator.popBackStack() },
                    modifier = Modifier.fillMaxSize()
                )
            }

            scene(
                route = "/details/{name}",
                navTransition = NavTransition(),
            ) { backStackEntry ->
                val name = backStackEntry.path<String>("name")
                val picture = Pictures.value.firstOrNull { it.name == name } ?: return@scene
                DetailsDialog(
                    picture = picture,
                    onBack = { navigator.popBackStack() },
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}