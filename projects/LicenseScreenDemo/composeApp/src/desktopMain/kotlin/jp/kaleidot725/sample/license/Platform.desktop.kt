package jp.kaleidot725.sample.license

import jp.kaleidot725.sample.license.data.License
import org.jetbrains.compose.resources.Resource
import org.jetbrains.compose.resources.resource
import java.awt.Desktop
import java.net.URI

actual fun openUrl(url: String) {
    val uri = url.let { URI.create(it) } ?: return
    Desktop.getDesktop().browse(uri)
}

actual suspend fun getLicenseResource(): Resource = resource("licensee/desktop/artifacts.json")
