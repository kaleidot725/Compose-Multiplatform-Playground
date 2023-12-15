sealed class Status {
    object Loading : Status()
    data class Success(val value: String) : Status()
    data class Error(val value: String) : Status()
}