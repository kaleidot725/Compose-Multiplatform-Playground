package voyager.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import common.content.DetailsContent
import common.content.PreviewContent
import common.resource.Picture


class PreviewScreen(
    private val picture: Picture
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        var isShowDeitals by remember { mutableStateOf(false) }

        PreviewContent(
            picture = picture,
            onBack = { navigator?.pop() },
            onNavigateDetails = { isShowDeitals = true },
            modifier = Modifier.fillMaxSize(),
        )

        if (isShowDeitals) {
            Dialog(onDismissRequest = { isShowDeitals = false }) {
                DetailsContent(
                    picture = picture,
                    onBack = { isShowDeitals = false },
                    modifier = Modifier.wrapContentSize()
                )
            }
        }
    }
}