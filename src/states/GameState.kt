package states

import Play

interface GameState {
    fun execute(play: Play)
}