package repositories.Knight
import data_models.KnightModel
import java.util.*

class KnightRepositoryConsole : AbstractKnightRepository() {
    override fun getKnightModel() : KnightModel {
        print("Knight input 'heath power defence' = ")
        val input = Scanner(System.`in`)
        val health = input.next().toInt()
        val power = input.next().toInt()
        val defence = input.next().toInt()
        println("Knight input end")
        return KnightModel(health, power, defence)
    }
}