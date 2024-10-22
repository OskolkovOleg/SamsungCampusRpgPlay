package repositories.robot
import data_models.RobotModel
import java.util.*

class RobotRepositoryConsole : AbstractRobotRepository() {
    override fun getRobotModel() : RobotModel {
        print("Robot input 'heath power buttery' = ")
        val input = Scanner(System.`in`)
        val health = input.next().toInt()
        val power = input.next().toInt()
        val buttery = input.next().toInt()
        println("Robot input end")
        return RobotModel(health, power, buttery)
    }
}