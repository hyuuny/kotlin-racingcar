package view

class InputUI {

    companion object {
        private const val START_INPUT_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        private const val START_INPUT_COUNT_MSG = "시도할 횟수는 몇회인가요?"

        fun printInputName() = println(START_INPUT_NAME_MSG)

        fun printInputCount() = println(START_INPUT_COUNT_MSG)
    }

}