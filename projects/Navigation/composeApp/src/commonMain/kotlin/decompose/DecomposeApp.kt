package decompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import common.resource.Pictures
import decompose.screen.DetailsDialog
import decompose.screen.GalleryScreen
import decompose.screen.PreviewScreen
import io.github.xxfast.decompose.router.Router
import io.github.xxfast.decompose.router.content.RoutedContent
import io.github.xxfast.decompose.router.rememberRouter

@Parcelize
sealed class Screens : Parcelable {
    data object Gallery : Screens()
    data class Preview(val name: String) : Screens()
    data class Details(val name: String) : Screens()
}

@Composable
fun DecomposeApp() {
    val router: Router<Screens> = rememberRouter(Screens::class) { listOf(Screens.Gallery) }
    RoutedContent(router = router) { screen ->
        when (screen) {
            Screens.Gallery -> {
                GalleryScreen(
                    pictures = Pictures.value,
                    onNavigatePreview = { router.push(Screens.Preview(it.name)) },
                    modifier = Modifier.fillMaxSize()
                )
            }

            is Screens.Preview -> {
                val picture = Pictures.value.firstOrNull { it.name == screen.name } ?: return@RoutedContent
                PreviewScreen(
                    picture = picture,
                    onNavigateDetails = { router.push(Screens.Details(it.name)) },
                    onBack = { router.pop() },
                    modifier = Modifier.fillMaxSize()
                )
            }

            is Screens.Details -> {
                val picture = Pictures.value.firstOrNull { it.name == screen.name } ?: return@RoutedContent
                DetailsDialog(
                    picture = picture,
                    onBack = { router.pop() },
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}