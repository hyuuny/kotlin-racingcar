package view

class OutputUI {

    companion object {
        private const val EXECUTION_RESULT = "실행결과"
        private const val FINAL_WINNERS = "최종 우승자 : "
        private const val DASH = "-"

        fun printExecutionResult() = println(EXECUTION_RESULT)

        fun printMovedPosition(position: Int): String {
            val stringBuilder = StringBuilder()
            for (i in 1..position) {
                stringBuilder.append(DASH)
            }
            return stringBuilder.toString()
        }

        fun printWinners(winner: String) {
            println(FINAL_WINNERS)
            println(winner)
            println()
        }

        fun printMsg(msg: String) = println(msg)
    }

}