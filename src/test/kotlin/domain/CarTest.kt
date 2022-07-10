package domain

import domain.MoveType.MOVE
import domain.MoveType.STOP
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test

internal class CarTest {

    @Test
    fun `차 생성`() {
        val newCar = Car("pobi")
        newCar shouldNotBe null
    }

    @Test
    fun `차 이름이 5글자 이상 예외`() {
        shouldThrow<IllegalArgumentException> {
            Car("pobipobi")
        }.shouldHaveMessage(ERROR_MSG + LENGTH_ERROR_MSG)
    }

    @Test
    fun `차 이름 조회`() {
        val expectedName = "pobi"
        val newCar = Car(expectedName)
        newCar.toName shouldBe expectedName
    }

    @Test
    fun `차 위치 조회 - 0으로 초기화된다`() {
        val expectedPosition = 0
        val newCar = Car("pobi")
        newCar.toPosition shouldBe expectedPosition
    }

    @Test
    fun `이동 테스트 - MOVE면 이동한다`() {
        val newCar = Car("pobi")
        newCar.toPosition shouldBe 0
        newCar.move(MOVE)
        newCar.toPosition shouldBe 1
    }

    @Test
    fun `이동테스트 - STOP은 이동하지 않는다`() {
        val newCar = Car("pobi")
        newCar.toPosition shouldBe 0
        newCar.move(STOP)
        newCar.toPosition shouldBe 0
    }

}