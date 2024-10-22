package models.robot

import data_models.HumanModel
import data_models.Model
import data_models.RobotModel
import models.Human
import kotlin.math.max

class Robot (
) : Human(){
    var buttery: Int = 0
    override fun attack(human: Human) {
        human.health -= (this.power*(this.buttery/10f)).toInt() // TODO random
    }

    override fun setDataModel(model: Model) : Human {
        if (model is RobotModel) {
            buttery = model.buttery
            health = model.health
            power = model.power
        } else if (model is HumanModel) {
            buttery = 100
            health = model.health
            power = model.power
        } else{
            println("Error Wizard setDataModel is await WizardModel")
        }
        return this
    }

    override fun heal() {
        health += (5*(this.buttery/10f)).toInt()
    }

    override fun damage(uron: Int) {
        health = max(health-uron, 0)
    }
}