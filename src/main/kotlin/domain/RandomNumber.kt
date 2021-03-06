package domain

class RandomNumber {
    companion object {
        private const val MIN_RANDOM_NUMBER = 0
        private const val MAX_RANDOM_NUMBER = 9

        fun pickNumberInRange() = (MIN_RANDOM_NUMBER..MAX_RANDOM_NUMBER).random()
    }
}