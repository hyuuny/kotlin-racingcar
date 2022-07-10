package domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class CarsTest {

    val pobi = Car("pobi")
    val crong = Car("crong")
    val honux = Car("honux")

    val moveCondition = MoveConditionImpl()

    @Test
    fun `차 목록 조회`() {
        val names = listOf(pobi.toName, crong.toName, honux.toName)
        val newCars = Cars.create(names)
        newCars.cars.size shouldBe names.size
    }

    @Test
    fun `pobi 단독 우승`() {
        val newCars = Cars.create(listOf(pobi.toName, crong.toName, honux.toName))
        newCars.cars[0].move(moveCondition.move(5))
        val winnerName = newCars.getWinners()
        winnerName shouldBe "pobi"
    }

    @Test
    fun `crong, honux 공동 우승`() {
        val newCars = Cars.create(listOf(pobi.toName, crong.toName, honux.toName))

        newCars.cars[1].move(moveCondition.move(5))
        newCars.cars[2].move(moveCondition.move(5))
        val winnerName = newCars.getWinners()
        winnerName shouldBe "crong, honux"
    }

}