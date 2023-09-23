package jp.kaleidot725.sample.license

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import jp.kaleidot725.sample.license.component.LicenseList
import jp.kaleidot725.sample.license.data.License
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

@Composable
internal fun App() = MaterialTheme {
    var isLoading by remember { mutableStateOf(false) }
    var licenses by remember { mutableStateOf(emptyList<License>()) }

    LaunchedEffect(isLoading) {
        if (isLoading.not()) {
            licenses = readLicenses()
            isLoading = false
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .windowInsetsPadding(WindowInsets.safeDrawing)
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            LicenseList(
                licenses = licenses,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

suspend fun readLicenses(): List<License> {
    return withContext(Dispatchers.IO) {
        val text = getLicenseResource().readBytes().decodeToString()
        Json.decodeFromString<List<License>>(text)
    }
}