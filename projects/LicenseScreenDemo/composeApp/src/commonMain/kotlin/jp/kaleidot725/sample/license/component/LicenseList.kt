package jp.kaleidot725.sample.license.component

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.kaleidot725.sample.license.data.License

@Composable
fun LicenseList(
    licenses: List<License>,
    modifier : Modifier = Modifier,
) {
    LazyColumn(modifier) {
        licenses.forEach { license ->
            item { LicenseCard(license) }
        }
    }
}