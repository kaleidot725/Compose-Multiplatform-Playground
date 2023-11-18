package common.resource

data class Picture(
    val name: String,
    val source: String
)

object Pictures {
    val value = listOf(
        Picture(name = "SAMPlE1", source = "001.jpg"),
        Picture(name = "SAMPlE2", source = "002.jpg"),
        Picture(name = "SAMPlE3", source = "003.jpg"),
        Picture(name = "SAMPlE4", source = "004.jpg"),
        Picture(name = "SAMPlE5", source = "005.jpg"),
        Picture(name = "SAMPlE6", source = "006.jpg"),
        Picture(name = "SAMPlE7", source = "007.jpg"),
        Picture(name = "SAMPlE8", source = "008.jpg"),
        Picture(name = "SAMPlE9", source = "009.jpg"),
        Picture(name = "SAMPlE10", source = "010.jpg"),
    )
}