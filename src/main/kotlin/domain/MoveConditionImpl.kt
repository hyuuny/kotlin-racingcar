package domain

class MoveConditionImpl() : MoveCondition {

    companion object {
        private const val NOT_MOVE = 3
    }

    override fun move(randomNumber: Int): MoveType =
        if (randomNumber > NOT_MOVE) MoveType.MOVE else MoveType.STOP
}