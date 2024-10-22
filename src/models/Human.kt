package models

import data_models.HumanModel
import data_models.Model

abstract class Human(
    var health: Int = 0,
    var power: Int = 0,
) {
    abstract fun setDataModel(model: Model) : Human
    abstract fun attack(human: Human)
    abstract fun heal()
    abstract fun damage(uron: Int)
}