package common.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import common.resource.Picture
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
fun GalleryContent(
    pictures: List<Picture>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
    ) {
        items(
            items = pictures,
            key = { it.name }
        ) { picture ->
            GalleryPictureCard(
                picture = picture,
                modifier = Modifier.height(250.dp)
            )
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
private fun GalleryPictureCard(picture: Picture, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.background(Color.Black)
    ) {
        Image(
            painter = painterResource(picture.source),
            contentDescription = picture.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier.align(Alignment.Center)
        )

        Text(
            text = picture.name,
            color = Color.White,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
                .align(Alignment.BottomCenter)
        )
    }
}