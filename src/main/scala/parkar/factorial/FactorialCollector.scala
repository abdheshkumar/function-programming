package parkar.factorial

import akka.actor.{Actor, ActorLogging, Props}

/**
  * Created by abdhesh on 9/5/16.
  */
class FactorialCollector(factorials: List[Int]) extends Actor with ActorLogging {
  var list: List[BigInt] = Nil
  var size = factorials.size

  for (num <- factorials)
    context.actorOf(Props(new FactorialCalculator)) ! num


  def receive = {
    case (num: Int, fac: BigInt) => {
      log.info(s"factorial for $num is $fac")

      list = num :: list
      size -= 1

      if (size == 0) context.system.terminate()

    }
  }
}
