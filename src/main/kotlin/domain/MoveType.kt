package domain

enum class MoveType {

    MOVE, STOP;

    fun isMove() = this == MOVE

}