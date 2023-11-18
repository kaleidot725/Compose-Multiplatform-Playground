package common.resource

data class Picture(
    val name: String,
    val source: String
)

object Pictures {
    val value = listOf(
        Picture(name = "SAMPlE1", source = "001.png"),
        Picture(name = "SAMPlE2", source = "002.png"),
        Picture(name = "SAMPlE3", source = "003.png"),
        Picture(name = "SAMPlE4", source = "004.png"),
        Picture(name = "SAMPlE5", source = "005.png"),
        Picture(name = "SAMPlE6", source = "006.png"),
        Picture(name = "SAMPlE7", source = "007.png"),
        Picture(name = "SAMPlE8", source = "008.png"),
    )
}