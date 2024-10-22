package models.knight
import data_models.HumanModel
import data_models.Model
import data_models.KnightModel
import models.Human
import kotlin.math.max

class Knight(
    health: Int = 0,
    power: Int = 0,
    var defence: Int = 0
) : Human(health, power){

    override fun attack(human: Human) {
        human.health -= (this.power*(this.defence/10f)).toInt() // TODO random
    }

    override fun setDataModel(model: Model) : Human {
        if (model is KnightModel) {
            defence = model.defence
            health = model.health
            power = model.power
        } else if (model is HumanModel) {
            defence = 100
            health = model.health
            power = model.power
        } else {
            println("Error Wizard setDataModel is await WizardModel")
        }
        return this
    }

    override fun heal() {
        health += (5*(this.defence/10f)).toInt()
    }

    override fun damage(uron: Int) {
        health = max(health-uron, 0)
    }
}