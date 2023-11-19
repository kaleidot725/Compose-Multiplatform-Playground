package common.resource

data class Picture(
    val name: String,
    val source: String
)

object Pictures {
    val value = listOf(
        Picture(name = "SAMPLE1", source = "001.jpg"),
        Picture(name = "SAMPLE2", source = "002.jpg"),
        Picture(name = "SAMPLE3", source = "003.jpg"),
        Picture(name = "SAMPLE4", source = "004.jpg"),
        Picture(name = "SAMPLE5", source = "005.jpg"),
        Picture(name = "SAMPLE6", source = "006.jpg"),
        Picture(name = "SAMPLE7", source = "007.jpg"),
        Picture(name = "SAMPLE8", source = "008.jpg"),
        Picture(name = "SAMPLE9", source = "009.jpg"),
        Picture(name = "SAMPLE10", source = "010.jpg"),
    )
}