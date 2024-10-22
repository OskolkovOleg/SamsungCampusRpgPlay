package repositories.wizard
import data_models.WizardModel
import java.util.*

class WizardRepositoryConsole : AbstractWizardRepository() {
    override fun getWizardModel() : WizardModel {
        print("Wizard input 'heath power mana' = ")
        val input = Scanner(System.`in`)
        val health = input.next().toInt()
        val power = input.next().toInt()
        val mana = input.next().toInt()
        println("Wizard input end")
        return WizardModel(health, power, mana)
    }
}