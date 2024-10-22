package data_models

data class KnightModel(
    val health : Int,
    val power : Int,
    val defence : Int
)  : Model {
    constructor(hum: HumanModel, defence: Int) : this(hum.health, hum.power, defence)
}
