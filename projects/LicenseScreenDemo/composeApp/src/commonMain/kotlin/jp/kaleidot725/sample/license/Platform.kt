package jp.kaleidot725.sample.license

import org.jetbrains.compose.resources.Resource

expect suspend fun getLicenseResource(): Resource
expect fun openUrl(url : String)
