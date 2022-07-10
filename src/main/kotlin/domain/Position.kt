package domain

data class Position(
    var position: Int = INIT_POSITION,
) {

    companion object {
        private const val ERROR_MSG = "[ERROR]"
        private const val POSITION_ERROR_MSG = " 위치는 0~9사이여야 합니다."
        private const val INIT_POSITION = 0
        private const val MINIMUM_POSITION = 0
        private const val MAXIMUM_POSITION = 9

        fun getMaxPosition(cars: List<Car>): Int {
            var maxPosition = cars.first().toPosition
            for (car in cars) {
                maxPosition = maxPosition.coerceAtLeast(car.toPosition)
            }
            return maxPosition
        }
    }

    init {
        verifyPosition(position)
    }

    private fun verifyPosition(position: Int) {
        if (MINIMUM_POSITION > position || MAXIMUM_POSITION < position)
            throw IllegalArgumentException(ERROR_MSG + POSITION_ERROR_MSG)
    }

    fun addPosition(): Position {
        this.position += 1
        return Position(this.position)
    }

    fun isEqualTo(position: Int) = this.position == position


}