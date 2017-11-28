import org.apache.spark.sql.SparkSession

object SparkSQLExample {

  def main(args: Array[String]) {
    // $example on:init_session$
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .master("local")
      .getOrCreate()

    val jdbcDF = spark.read
      .format("jdbc")
      .option("url", "jdbc:postgresql://10.1.12.60:5432/TestDB")
//            .option("dbtable", "test_taxi_stream.taxi_logs")
      .option("dbtable", "test_taxi_stream.links")
      .option("user", "postgres")
      .option("password", "asdf1234")
      .load()

    jdbcDF.filter(jdbcDF("region_id") === 175).show()

    //    for (link <- a ) {
    //      println(link.mkString(","))
    //    }

    //    runBasicDataFrameExample(spark)
    //    runDatasetCreationExample(spark)
    //    runInferSchemaExample(spark)
    //    runProgrammaticSchemaExample(spark)

    spark.stop()
  }
}