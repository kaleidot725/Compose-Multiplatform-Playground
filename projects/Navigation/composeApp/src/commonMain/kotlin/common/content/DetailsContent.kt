package common.content

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import common.resource.Picture

@Composable
fun DetailsContent(
    picture: Picture,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        Text(text = "TITLE : ${picture.name}")
        Text(text = "FILE : ${picture.source}")
    }
}
