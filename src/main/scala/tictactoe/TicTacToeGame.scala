package tictactoe

import scalafx.scene.layout.GridPane
import scalafx.scene.control.Button
import scalafx.geometry.Insets

class TicTacToeGame {
  private val grid = new GridPane {
    hgap = 10
    vgap = 10
    padding = Insets(20)
  }

  private var currentPlayer = "X"
  private val board = Array.fill(3, 3)("")

  for (i <- 0 until 3; j <- 0 until 3) {
    val button = new Button {
      text = ""
      prefWidth = 100
      prefHeight = 100
      onAction = _ => handleMove(this, i, j)
    }
    grid.add(button, i, j)
  }

  def getGrid: GridPane = grid

  private def handleMove(button: Button, row: Int, col: Int): Unit = {
    if (button.text.value.isEmpty && board(row)(col).isEmpty) {
      button.text = currentPlayer
      board(row)(col) = currentPlayer
      if (checkWin(row, col)) {
        println(s"Player $currentPlayer wins!")
        resetGame()
      } else if (isDraw()) {
        println("It's a draw!")
        resetGame()
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

  private def resetGame(): Unit = {
    for (i <- 0 until 3; j <- 0 until 3) {
      board(i)(j) = ""
    }
    grid.children.filter(_.isInstanceOf[Button]).map(_.asInstanceOf[Button]).foreach(_.text = "")
    currentPlayer = "X"
  }
}
