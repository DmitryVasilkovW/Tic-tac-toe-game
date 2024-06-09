import scala.collection.Seq

name := "TicTacToe"

version := "0.1"

scalaVersion := "3.3.1"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "20.0.0-R31",
)

javaOptions ++= Seq(
  "--module-path", "/path/to/javafx-sdk-17/lib",
  "--add-modules", "javafx.controls"
)
