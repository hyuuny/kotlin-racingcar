package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test
import view.OutputUI

const val POSITION_ERROR_MSG = " 위치는 0~9사이여야 합니다."

internal class PositionTest {

    @Test
    internal fun `위치는 0으로 초기화된다`() {
        val newPosition = Position()
        newPosition.position shouldBe 0
    }

    @Test
    internal fun `생성 시점에 위치 0~9를 벗어나면 예외`() {
        shouldThrow<IllegalArgumentException> {
            Position(13)
        }.shouldHaveMessage(ERROR_MSG + POSITION_ERROR_MSG)
    }

    @Test
    internal fun `addPosition을 호출하면 현재 위치 + 1`() {
        val expectedPosition = 1
        val newPosition = Position()
        newPosition.addPosition().position shouldBe expectedPosition
    }

    @Test
    internal fun `position 값은 7이다`() {
        val position = Position(7)
        position.isEqualTo(7) shouldBe true
    }

    @Test
    internal fun `position이 3이면 ---으로 조회된다`() {
        val expectedDash = "---"
        val newPosition = Position(3)
        OutputUI.printMovedPosition(newPosition.position) shouldBe expectedDash
    }

}