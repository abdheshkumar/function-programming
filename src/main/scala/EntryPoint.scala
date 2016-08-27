
import scala.annotation.tailrec
import scala.io.Source

/**
 * Created by Abdhesh.Kumar on 25-08-2016.
 */
case class Card(name: String, value: Int)

object EntryPoint {

  lazy val cards = Map(
    "A" -> 1, "2" -> 2, "3" -> 3, "4" -> 4,
    "5" -> 5, "6" -> 6, "7" -> 7, "8" -> 8,
    "9" -> 9, "T" -> 10, "J" -> 11, "Q" -> 12,
    "K" -> 13)

  lazy val arjunCards = readCards( """src\main\resources\data\Arjun.txt""")
  lazy val duryodhanaCards = readCards( """src\main\resources\data\Duryodhana.txt""")

  def readCards(fileName: String) =
  Source.fromFile(fileName)
    .getLines()
    .flatMap(_.toCharArray.toList)
    .map(f => Card(f.toString, cards(f.toString)))
    .toList


  def output(cardInHand: List[Card], winnerName: String): Unit = {
    println(
      s"""
         |Answer 2.a: ${winnerName} Won the Game!
         |Answer 2.b: Size of winner's (${winnerName}) deck at end of the game is:${cardInHand.size}
          |Answer 2.c: Last pair of cards played in the game:${(cardInHand(cardInHand.size - 2).name, cardInHand.last.name)}
          """.stripMargin)
  }

  @tailrec
  def winner(arjunCards: List[Card], duryodhanaCards: List[Card]): Unit = {
    (arjunCards, duryodhanaCards) match {
      case (ar, Nil) => output(ar,"Arjun")
      case (Nil, du) => output(du,"Duryodhana")
      case ((arHead :: aTail), (duHead :: duTail)) =>
        if (arHead == duHead) winner(aTail, duTail)
        else {
          if (arHead.value < duHead.value) winner(aTail, duTail ++ List(duHead, arHead))
          else winner(aTail ++ List(arHead, duHead), duTail)
        }
    }
  }

  def main(array: Array[String]) = winner(arjunCards, duryodhanaCards)
}
