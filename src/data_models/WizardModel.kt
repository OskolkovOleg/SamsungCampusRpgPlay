package data_models

data class WizardModel(
    val health : Int,
    val power : Int,
    val mana : Int
)  : Model {
    constructor(hum: HumanModel, mana: Int) : this(hum.health, hum.power, mana)
}

