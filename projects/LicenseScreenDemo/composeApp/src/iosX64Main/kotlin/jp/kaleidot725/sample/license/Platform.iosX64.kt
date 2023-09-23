package jp.kaleidot725.sample.license

import jp.kaleidot725.sample.license.data.License
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.resource
import platform.Foundation.NSURL
import platform.UIKit.UIApplication

actual fun openUrl(url: String) {
    val nsUrl = url.let { NSURL.URLWithString(it) } ?: return
    UIApplication.sharedApplication.openURL(nsUrl)
}

actual suspend fun getLicenseResource(): Resource = resource("licensee/iosX64/artifacts.json")
