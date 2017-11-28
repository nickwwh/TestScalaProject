

import org.apache.spark.sql.SparkSession

object WordCount {

  def main(args: Array[String]) {

    //Create a SparkContext to initialize Spark
    val ss = SparkSession.builder()
      .master("local")
      .appName("Word Count")
      .getOrCreate()

    // Load the text into a Spark RDD, which is a distributed representation of each line of text
    import ss.implicits._
    val dataSetString = ss.read.text("src/main/resources/shakespeare.txt").as[String]
    val words = dataSetString.flatMap(value => value.split("\\W*[\\s\\n]+|\\W$")).filter(!_.isEmpty)
    val count = words.groupByKey(_.toLowerCase).count
//    count.show
    count.orderBy($"count(1)".desc).show
    //word count

    //    count.collect.foreach(println)
  }

}
