package domain

data class Name(
    val name: String,
) {

    companion object {
        private const val ERROR_MSG = "[ERROR]"
        private const val LENGTH_ERROR_MSG = " 이름은 5글자이하여야 합나다."
        private const val EMPTY_ERROR_MSG = " 이름은 공백일 수 없습니다."
        private const val NAME_MAXIMUM_SIZE = 5
    }

    init {
        verifyName(name)
    }

    private fun verifyName(name: String) {
        if (name.trim().isEmpty())
            throw IllegalArgumentException(ERROR_MSG + EMPTY_ERROR_MSG)

        if (name.trim().length > NAME_MAXIMUM_SIZE)
            throw IllegalArgumentException(ERROR_MSG + LENGTH_ERROR_MSG)
    }

}