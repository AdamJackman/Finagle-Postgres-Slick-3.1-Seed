lazy val versions = new {
  val scalaVersion  = "2.11.7"
  val finatraVersion = "2.3.0"
}

lazy val root = (project in file("."))
  .settings(
    name := "lla-be",
    version := "1.0",
    scalaVersion := versions.scalaVersion,
    parallelExecution in ThisBuild := false,
    resolvers += "Twitter" at "http://maven.twttr.com",
    mainClass := Some("io.lla.ServerMain"),
    libraryDependencies ++= Seq(
      "com.twitter" %% "finagle-http" % "6.34.0",
      "com.twitter" %% "finatra-http" % versions.finatraVersion,
      "com.twitter" %% "finatra-jackson" % versions.finatraVersion,
      "com.twitter" %% "finatra-root" % versions.finatraVersion,
      "com.twitter" %% "inject-app" % versions.finatraVersion,
      "com.twitter" %% "inject-core" % versions.finatraVersion,
      "com.twitter" %% "inject-server" % versions.finatraVersion,
      //Slick dependencies
      "com.typesafe.slick" %% "slick" % "3.1.1",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.1.1",
      "org.postgresql" % "postgresql" % "9.4-1206-jdbc4",
      "org.slf4j" % "slf4j-nop" % "1.6.4"
    )
  )
