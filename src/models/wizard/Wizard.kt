package models.wizard

import data_models.HumanModel
import data_models.Model
import data_models.WizardModel
import models.Human
import kotlin.math.max

class Wizard(

) : Human(){
    var mana: Int = 0
    override fun attack(human: Human) {
        human.damage((this.power*(this.mana/10f)).toInt()) // TODO random
    }

    override fun setDataModel(model: Model) : Human {
        if (model is WizardModel) {
            mana = model.mana
            health = model.health
            power = model.power
        } else if (model is HumanModel) {
            mana = 100
            health = model.health
            power = model.power
        } else{
            println("Error Wizard setDataModel is await WizardModel")
        }
        return this
    }

    override fun heal() {
        health += (5*(this.mana/10f)).toInt()
    }

    override fun damage(uron: Int) {
        health = max(health-uron, 0)
    }
}