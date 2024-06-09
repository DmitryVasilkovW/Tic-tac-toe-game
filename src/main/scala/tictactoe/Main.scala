package tictactoe

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene

object Main extends JFXApp3 {
  override def start(): Unit = {
    val ticTacToeGame = new TicTacToeGame
    stage = new PrimaryStage {
      title = "Tic Tac Toe"
      scene = new Scene(ticTacToeGame.getGrid, 320, 320)
    }
  }
}
