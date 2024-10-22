package data_models

data class RobotModel(
    val health : Int,
    val power : Int,
    val buttery : Int
)  : Model {
    constructor(hum: HumanModel, buttery: Int) : this(hum.health, hum.power, buttery)
}
