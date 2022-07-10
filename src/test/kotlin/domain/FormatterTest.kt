package domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class FormatterTest {

    @Test
    fun `콤마를 기준으로 문자를 자른다 - 총 3개의 요소가 있다`() {
        val str = "pobi,crong,honux"
        val splitedStr = Formatter.splitToList(str)
        splitedStr[0] shouldBe "pobi"
        splitedStr[1] shouldBe "crong"
        splitedStr[2] shouldBe "honux"
    }

}