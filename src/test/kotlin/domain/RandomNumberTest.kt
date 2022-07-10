package domain

import domain.RandomNumber.Companion.pickNumberInRange
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import org.junit.jupiter.api.Test

internal class RandomNumberTest {

    @Test
    fun `랜덤 번호 생성`() {
        val randomNumber = pickNumberInRange()
        randomNumber shouldBeGreaterThanOrEqual 0
        randomNumber shouldBeLessThanOrEqual 9
    }

}