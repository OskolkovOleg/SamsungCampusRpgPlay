package states

import Play
import models.knight.Knight
import models.robot.Robot
import models.wizard.Wizard
import repositories.Knight.KnightRepositoryConsole
import repositories.robot.RobotRepositoryConsole
import repositories.wizard.WizardRepositoryConsole

class MainMenuState : GameState {
    override fun execute(play: Play) {
        println("""
        |Выберете себе персонажа:
        |   1 - Маг
        |   2 - Робот
        |   3 - Рыцарь
        |   0 - Выход
        """.trimMargin())
        print("> ")

        when (play.scanner.next()) {
            "0" -> play.changeState(ExitState())
            "1" -> {
                play.player = Wizard().setDataModel(WizardRepositoryConsole().getWizardModel())
                play.changeState(BattleState())  // Переход в боевое состояние
            }
            "2" -> {
                play.player = Robot().setDataModel(RobotRepositoryConsole().getRobotModel())
                play.changeState(BattleState())
            }
            "3" -> {
                play.player = Knight().setDataModel(KnightRepositoryConsole().getKnightModel())
                play.changeState(BattleState())
            }
            else -> {
                println("Некорректный ввод")
                execute(play)
            }
        }
    }
}