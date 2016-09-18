package example

/**
 * Created by Abdhesh.Kumar on 18-09-2016.
 */
object Solution3 {
  //problem : https://www.hackerrank.com/challenges/reduced-string
  def main(args: Array[String]) {
    val sc = new java.util.Scanner(System.in);
    val in = sc.next
    val sb = new StringBuilder(in)
    def hasSameSequenceChars(sb: StringBuilder) = (0 to sb.length - 1).sliding(2).exists(x => {
      x.toList match {
        case first :: second :: Nil if sb.charAt(first) == sb.charAt(second) =>
          sb.deleteCharAt(second)
          sb.deleteCharAt(first)
          embedDefaultValue(sb)
          true
        case _ =>
          embedDefaultValue(sb)
          false
      }
    })

    def embedDefaultValue(sb: StringBuilder) = if (sb.isEmpty) sb.append("Empty String")
    val res = Iterator.continually(sb).takeWhile(hasSameSequenceChars).toList.lastOption.get

    println(res)
  }
}