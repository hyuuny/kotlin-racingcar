package domain

data class Car(
    val name: Name,
    val position: Position = Position(),
) {

    constructor(name: String) : this(
        name = Name(name)
    )

    val toName: String
        get() = this.name.name

    val toPosition: Int
        get() = this.position.position

    fun move(move: MoveType) {
        if (move.isMove()) {
            this.position.addPosition()
        }
    }

    fun isPositionEqual(position: Int) = this.position.isEqualTo(position)

}