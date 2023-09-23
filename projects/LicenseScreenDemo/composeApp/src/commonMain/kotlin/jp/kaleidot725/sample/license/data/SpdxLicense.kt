package jp.kaleidot725.sample.license.data

import kotlinx.serialization.Serializable

@Serializable
data class SpdxLicense(
    val identifier: String,
    val name: String,
    val url: String,
)
