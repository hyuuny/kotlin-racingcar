package controller

import domain.Cars
import domain.Formatter
import domain.MoveConditionImpl
import view.InputUI
import view.InputUI.Companion.printInputCount
import view.OutputUI
import view.OutputUI.Companion.printWinners

class RacingController {

    private var cars: Cars = Cars(mutableListOf())

    private var count = 0L

    fun start() {
        try {
            this.inputCarName()
            this.inputCount()
            this.racing()
            printWinners(this.cars.getWinners())
        } catch (e: IllegalArgumentException) {
            OutputUI.printMsg(e.message.toString())
            this.start()
        }
    }

    private fun inputCount() {
        printInputCount()
        count = readLine()!!.toLong()
    }

    private fun inputCarName() {
        InputUI.printInputName()
        val carNames = readLine()!!
        cars = Cars.create(Formatter.splitToList(carNames))
    }

    private fun racing() {
        val condition = MoveConditionImpl()
        while (this.count > 0) {
            this.cars.move(condition)
            OutputUI.printRacing(this.cars.cars)
            this.count -= 1
            OutputUI.printEmpty()
        }
    }

}