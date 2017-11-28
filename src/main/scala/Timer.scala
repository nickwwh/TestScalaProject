package main.scala

object Timer {
  def main(args: Array[String]): Unit = {
    oncePerSecond(timeFlies)
  }

  def oncePerSecond(callback: () => Unit): Unit = {
    while (true) {
      callback()
      Thread.sleep(1000)
    }
  }

  def timeFlies(): Unit = {
    Console.println("Time flies when you're having fun(ctionally)...");
  }
}