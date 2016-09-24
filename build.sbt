lazy val versions = new {
  val scalaVersion  = "2.11.7"
  val finagleVersion = "6.34.0"
  val finatraVersion = "2.4.0"
  val guiceVersion = "4.0"
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
      "com.twitter" %% "finagle-http" % versions.finagleVersion,
      "com.twitter" %% "finatra-http" % versions.finatraVersion,
      "com.twitter" %% "finatra-jackson" % versions.finatraVersion,
      "com.twitter" %% "finatra-root" % versions.finatraVersion,
      "com.twitter" %% "finatra-thrift" % versions.finatraVersion,
      "com.twitter" %% "inject-app" % versions.finatraVersion,
      "com.twitter" %% "inject-core" % versions.finatraVersion,
      "com.twitter" %% "inject-server" % versions.finatraVersion,
      "com.twitter" %% "inject-modules" % versions.finatraVersion,
      // Slick dependencies
      "com.typesafe.slick" %% "slick" % "3.1.1",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.1.1",
      "org.postgresql" % "postgresql" % "9.4-1206-jdbc4",
      "org.slf4j" % "slf4j-nop" % "1.6.4",
      // Testing
      "com.twitter" %% "finatra-http" % versions.finatraVersion % "test",
      "com.twitter" %% "finatra-jackson" % versions.finatraVersion % "test",
      "com.twitter" %% "inject-app" % versions.finatraVersion % "test",
      "com.twitter" %% "inject-core" % versions.finatraVersion % "test",
      "com.twitter" %% "inject-server" % versions.finatraVersion % "test",
      "com.twitter" %% "inject-modules" % versions.finatraVersion % "test",
      "com.google.inject.extensions" % "guice-testlib" % versions.guiceVersion % "test",

      "com.twitter" %% "finatra-http" % versions.finatraVersion % "test" classifier "tests",
      "com.twitter" %% "finatra-jackson" % versions.finatraVersion % "test" classifier "tests",
      "com.twitter" %% "inject-app" % versions.finatraVersion % "test" classifier "tests",
      "com.twitter" %% "inject-core" % versions.finatraVersion % "test" classifier "tests",
      "com.twitter" %% "inject-server" % versions.finatraVersion % "test" classifier "tests",
      "com.twitter" %% "inject-modules" % versions.finatraVersion % "test" classifier "tests",

      "org.mockito" % "mockito-core" % "1.9.5" % "test",
      "org.scalatest" %% "scalatest" % "2.2.3" % "test",
      "org.specs2" %% "specs2" % "2.3.12" % "test"
    )
  )
