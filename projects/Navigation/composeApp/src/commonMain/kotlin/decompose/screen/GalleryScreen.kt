package decompose.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.content.GalleryContent
import common.resource.Picture

@Composable
fun GalleryScreen(
    pictures: List<Picture>,
    onNavigatePreview: (Picture) -> Unit,
    modifier: Modifier = Modifier,
) {
    GalleryContent(
        pictures = pictures,
        onClick = onNavigatePreview,
        modifier = modifier
    )
}