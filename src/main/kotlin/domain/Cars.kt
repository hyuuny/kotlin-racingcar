package domain

import domain.Position.Companion.getMaxPosition
import domain.RandomNumber.Companion.pickNumberInRange

data class Cars(
    var cars: MutableList<Car>,
) {

    companion object {
        private const val COMMA = ", "

        fun create(names: List<String>): Cars {
            val cars = mutableListOf<Car>()
            for (name in names) {
                cars.add(Car(name.trim()))
            }
            return Cars(cars)
        }
    }

    fun move(condition: MoveCondition) = this.cars
        .forEach { car -> car.move(condition.move(pickNumberInRange())) }

    fun getWinners(): String {
        val winnerNames = mutableListOf<String>()
        val maxPosition = getMaxPosition(this.cars)

        for (car in this.cars) {
            addWinners(winnerNames, maxPosition, car)
        }
        return winnerNames.joinToString(COMMA)
    }

    private fun addWinners(winnersName: MutableList<String>, maxPosition: Int, car: Car) {
        if (car.isPositionEqual(maxPosition)) {
            winnersName.add(car.toName)
        }
    }

}



