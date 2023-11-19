package voyager.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import common.content.DetailsContent
import common.content.PreviewContent
import common.resource.Picture

class PreviewScreenModel(
    val picture: Picture
) : ScreenModel

class PreviewScreen(
    private val picture: Picture
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var isShowDeitals by remember { mutableStateOf(false) }
        val screenModel = rememberScreenModel { PreviewScreenModel(picture) }

        PreviewContent(
            picture = screenModel.picture,
            onBack = { navigator?.pop() },
            onNavigateDetails = { isShowDeitals = true },
            modifier = Modifier.fillMaxSize(),
        )

        if (isShowDeitals) {
            Dialog(onDismissRequest = { isShowDeitals = false }) {
                DetailsContent(
                    picture = screenModel.picture,
                    onBack = { isShowDeitals = false },
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}