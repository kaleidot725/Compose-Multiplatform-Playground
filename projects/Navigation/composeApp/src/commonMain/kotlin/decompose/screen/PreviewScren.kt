package decompose.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.content.PreviewContent
import common.resource.Picture

@Composable
fun PreviewScreen(
    picture: Picture,
    onNavigateDetails: (Picture) -> Unit,
    onBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    PreviewContent(
        picture = picture,
        onBack = onBack,
        onNavigateDetails = { onNavigateDetails(picture) },
        modifier = modifier,
    )
}