package tictactoe

import scalafx.scene.layout.GridPane
import scalafx.scene.control.{Button, Alert, ButtonType}
import scalafx.geometry.Insets

class TicTacToeGame {
  private var grid = createGrid()

  private var currentPlayer = "X"
  private val board = Array.fill(3, 3)("")

  def getGrid: GridPane = grid

  private def createGrid(): GridPane = {
    val newGrid = new GridPane {
      hgap = 10
      vgap = 10
      padding = Insets(20)
    }

    for (i <- 0 until 3; j <- 0 until 3) {
      val button = new Button {
        text = ""
        prefWidth = 100
        prefHeight = 100
        onAction = _ => handleMove(this, i, j)
      }
      newGrid.add(button, i, j)
    }

    newGrid
  }

  private def handleMove(button: Button, row: Int, col: Int): Unit = {
    if (button.text.value.isEmpty && board(row)(col).isEmpty) {
      button.text = currentPlayer
      board(row)(col) = currentPlayer

      if (checkWin(row, col)) {
        showResult(s"Player $currentPlayer wins!")
      } else if (isDraw()) {
        showResult("It's a draw!")
      } else {
        currentPlayer = if (currentPlayer == "X") "O" else "X"
      }
    }
  }

  private def checkWin(row: Int, col: Int): Boolean = {
    val line = board(row)(col)

    (board(row).forall(_ == line) ||
      board.forall(_(col) == line) ||
      (row == col && (0 until 3).forall(i => board(i)(i) == line)) ||
      (row + col == 2 && (0 until 3).forall(i => board(i)(2 - i) == line)))
  }

  private def isDraw(): Boolean = {
    board.flatten.forall(_.nonEmpty)
  }

  private def showResult(message: String): Unit = {
    val alert = new Alert(Alert.AlertType.Information) {
      title = "Game Over"
      headerText = message
      contentText = "Would you like to play again?"
      buttonTypes = Seq(ButtonType.Yes, ButtonType.No)
    }

    val result = alert.showAndWait()

    result match {
      case Some(ButtonType.Yes) => resetGame()
      case Some(ButtonType.No) => System.exit(0)
      case _ =>
    }
  }

  private def resetGame(): Unit = {
    grid = createGrid()
    board.foreach(row => row.foreach(_ => ""))
    currentPlayer = "X"
  }
}
