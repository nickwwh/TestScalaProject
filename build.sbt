name := "TestScalaProject"
version := "1.0"
val sparkVersion = "2.2.0"
libraryDependencies += "org.apache.spark" %% "spark-sql" % sparkVersion
libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion
libraryDependencies += "org.postgresql" % "postgresql" % "9.3-1102-jdbc41"
