import scala.io.Codec.string2codec
import scala.io.Source
import scala.reflect.io.File

object WordCounter {
    val SrcDestination: String = ".." + File.separator + "file.txt"
    val Word = "\\b([A-Za-z\\-])+\\b".r

    def main(args: Array[String]): Unit = {

        val counter = Source.fromFile(SrcDestination)("UTF-8")
                .getLines
                .map(l => Word.findAllIn(l.toLowerCase()).toSeq)
                .toStream
                .groupBy(identity)
                .mapValues(_.length)

        println(counter)
    }
}