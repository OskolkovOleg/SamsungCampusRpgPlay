package states
import Play

class ExitState : GameState {
    override fun execute(play: Play) {
        println("EXIT PLAY")
        play.isRunning = false
    }
}