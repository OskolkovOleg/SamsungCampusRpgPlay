package states

import Play
import models.Human
import models.knight.Knight
import models.robot.Robot
import models.wizard.Wizard
import repositories.Knight.KnightRepositoryConsole
import repositories.robot.RobotRepositoryConsole
import repositories.wizard.WizardRepositoryConsole

class BattleState : GameState {
    lateinit var enemy : Human

    override fun execute(play: Play) {
        enemy = play.generateEnemy(0)
        println("Сразитесь с ${enemy::class.simpleName}, его health: ${enemy.health}")
        // Здесь можно добавить логику сражения.
        // Блок
        // Накопление способности
        // Удар
        // Хилл
        while (enemy.health > 0 && play.player.health > 0) {
            selectBattleAction(play)
            generateActionForEnemy(play)
        }
        println("${enemy.health} ${play.player.health}")
        // После боя вернёмся в главное меню
        play.changeState(MainMenuState())
    }

    private fun selectBattleAction(play: Play) {
        println("""
        |Выберете действие:
        |   1 - Удар
        |   2 - Хилл
        """.trimMargin())
//        |3 - Блок
//        |4 - Накопление способности
        print("> ")

        when (play.scanner.next()) {
            "0" -> play.changeState(ExitState())
            "1" -> {
                play.player.attack(enemy)
            }
            "2" -> {
                play.player.heal()
            }
            else -> {
                println("Некорректный ввод")
                selectBattleAction(play)
            }
        }
    }

    private fun generateActionForEnemy(play: Play) {
        val randomAction = (1..2).random()
        when (randomAction) {
            1 -> {
                enemy.attack(play.player)
            }
            2 -> {
                enemy.heal()
            }
        }
    }
}