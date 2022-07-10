package domain

interface MoveCondition {

    fun move(randomNumber: Int): MoveType
    
}