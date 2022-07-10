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
            this.addNames(names, cars)
            return Cars(cars)
        }

        private fun addNames(names: List<String>, cars: MutableList<Car>) =
            names.forEach { name -> cars.add(Car(name.trim())) }
    }

    fun move(condition: MoveCondition) = this.cars
        .forEach { car -> car.move(condition.move(pickNumberInRange())) }

    fun getWinners(): String {
        val winnerNames = mutableListOf<String>()
        val maxPosition = getMaxPosition(this.cars)
        this.addWinnerNames(winnerNames, maxPosition)
        return winnerNames.joinToString(COMMA)
    }

    private fun addWinnerNames(winnerNames: MutableList<String>, maxPosition: Int) =
        this.cars.forEach { car -> addWinners(winnerNames, maxPosition, car) }

    private fun addWinners(winnersName: MutableList<String>, maxPosition: Int, car: Car) {
        if (car.isPositionEqual(maxPosition)) winnersName.add(car.toName)
    }

}



