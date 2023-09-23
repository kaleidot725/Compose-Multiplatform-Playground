package jp.kaleidot725.sample.license

import android.content.Intent
import android.net.Uri
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.resource

actual fun openUrl(url: String) {
    val uri = url.let { Uri.parse(it) } ?: return
    val intent = Intent().apply {
        action = Intent.ACTION_VIEW
        data = uri
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    }
    AndroidApp.INSTANCE.startActivity(intent)
}

actual suspend fun getLicenseResource(): Resource = resource("licensee/android/artifacts.json")