package domain

data class Position(
    val position: Int = INIT_POSITION,
) {

    companion object {
        private const val ERROR_MSG = "[ERROR]"
        private const val POSITION_ERROR_MSG = " 위치는 0~9사이여야 합니다."
        private const val INIT_POSITION = 0
        private const val MINIMUM_POSITION = 0
        private const val MAXIMUM_POSITION = 9
    }

    init {
        verifyPosition(position)
    }

    private fun verifyPosition(position: Int) {
        if (MINIMUM_POSITION > position || MAXIMUM_POSITION < position)
            throw IllegalArgumentException(ERROR_MSG + POSITION_ERROR_MSG)
    }

    fun addPosition() = Position(this.position + 1)

    fun isEqualTo(position: Int) = this.position == position

}