package parkar.factorial

import akka.actor.{ActorSystem, Props}

/**
  * Created by abdhesh on 9/5/16.
  */
object FactorialAkka extends App {
  val factorials = List(20, 18, 32, 28, 22, 42, 55, 48)
  //List(200000, 180000, 320000, 280000, 220000, 420000, 550000, 480000)

  val system = ActorSystem("factorial")

  val collector = system.actorOf(Props(new FactorialCollector(factorials)), "collector")
}