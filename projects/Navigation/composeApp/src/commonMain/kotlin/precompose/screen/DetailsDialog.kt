package precompose.screen

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import common.content.DetailsContent
import common.resource.Picture

@Composable
fun DetailsDialog(
    picture: Picture,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Dialog(onDismissRequest = onBack) {
        DetailsContent(
            picture = picture,
            onBack = onBack,
            modifier = modifier,
        )
    }
}