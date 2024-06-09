package tictactoe

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.layout.Pane

object Main extends JFXApp3 {

  override def start(): Unit = {
    val rootPane = new Pane()
    val ticTacToeGame = new TicTacToeGame(rootPane)

    stage = new PrimaryStage {
      title = "Tic Tac Toe"
      scene = new Scene(rootPane, 320, 320)
    }
  }
}
