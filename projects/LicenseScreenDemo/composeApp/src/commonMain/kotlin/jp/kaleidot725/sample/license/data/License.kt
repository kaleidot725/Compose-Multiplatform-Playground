package jp.kaleidot725.sample.license.data

import kotlinx.serialization.Serializable

@Serializable
data class License(
    val artifactId: String,
    val groupId: String,
    val name: String,
    val scm: Scm,
    val spdxLicenses: List<SpdxLicense>,
    val version: String,
)
