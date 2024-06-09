import scala.collection.Seq

name := "TicTacToe"

version := "0.1"

scalaVersion := "3.3.1"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "20.0.0-R31",
)

javaOptions ++= Seq(
  "--add-modules", "javafx.controls"
)
