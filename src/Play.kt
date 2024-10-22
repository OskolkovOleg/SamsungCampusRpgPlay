import data_models.HumanModel
import models.Human
import models.knight.Knight
import models.robot.Robot
import models.wizard.Wizard
import states.GameState
import states.MainMenuState
import java.util.Scanner

class Play {
    lateinit var player: Human
    val scanner = Scanner(System.`in`)
    private var state: GameState = MainMenuState()  // Начальное состояние
    var isRunning: Boolean = true

    fun changeState(newState: GameState) {
        state = newState
    }

    fun runPlay() {
        println("GO PLAY")
        while (isRunning) {
            state.execute(this)
        }
    }

    fun generateEnemy(level: Int): Human {
        val enemies = listOf(Wizard(), Robot(), Knight())
        val enemy = enemies.random()
        return enemy.setDataModel(HumanModel(health = (1..100).random(), power = (1..100).random()))
    }
}