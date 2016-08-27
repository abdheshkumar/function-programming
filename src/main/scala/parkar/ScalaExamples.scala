package parkar

/**
 * Created by Abdhesh.Kumar on 26-08-2016.
 */
object ScalaExamples {

  //1. Multiple Each Item in a List by 2
  (1 to 10) map (_ * 2)

  //2. Sum a List of Numbers
  (1 to 1000).sum

  //3. Verify if Exists in a String
  val wordList = List("scala", "akka", "play framework", "sbt", "typesafe")
  val tweet = "This is an example tweet talking about scala and sbt."
  wordList.exists(tweet.contains)

  //4. Read in a File
  val fileLines = io.Source.fromFile("data.txt").getLines.toList

  //5.Filter list of numbers
  val (passed, failed) = List(49, 58, 76, 82, 88, 90) partition ( _ > 60 )

  //6. Find minimum (or maximum) in a List
  List(14, 35, -7, 46, 98).min
  List(14, 35, -7, 46, 98).max


}
