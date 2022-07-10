package domain

class Formatter {

    companion object {
        private const val COMMA = ","

        fun splitToList(str: String) = str.split(COMMA)
    }

}