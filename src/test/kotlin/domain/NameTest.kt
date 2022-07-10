package domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.Test

const val ERROR_MSG = "[ERROR]"
const val LENGTH_ERROR_MSG = " 이름은 5글자이하여야 합나다."
const val EMPTY_ERROR_MSG = " 이름은 공백일 수 없습니다."

internal class NameTest {

    @Test
    fun `이름 Empty 예외`() {
        shouldThrow<IllegalArgumentException> {
            Name(" ")
        }.shouldHaveMessage(ERROR_MSG + EMPTY_ERROR_MSG)
    }

    @Test
    fun `이름 다섯 글자 이상 예외`() {
        shouldThrow<IllegalArgumentException> {
            Name("superPobi")
        }.shouldHaveMessage(ERROR_MSG + LENGTH_ERROR_MSG)
    }

    @Test
    fun `이름 등록`() {
        val exceptedName = "pobi"
        val newName = Name(exceptedName)
        newName.name shouldBe exceptedName
    }

}