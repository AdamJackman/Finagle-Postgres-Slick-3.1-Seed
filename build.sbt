lazy val versions = new {
  val scala  = "2.12.1"
  val finatra = "2.13.0"
  val guice = "4.0"
}

lazy val root = (project in file("."))
  .settings(
    name := "seed",
    version := "1.1",
    scalaVersion := versions.scala,
    parallelExecution in ThisBuild := false,
    resolvers ++= Seq(
      "Twitter" at "http://maven.twttr.com",
      "Artima Maven Repository" at "http://repo.artima.com/releases"
    ),
    mainClass := Some("io.seed.ServerMain"),
    libraryDependencies ++= Seq(
      //Fiantra Http
      "com.twitter" %% "finatra-http" % versions.finatra,
      // Slick dependencies
      "com.typesafe.slick" %% "slick"          % "3.2.1",
      "com.typesafe.slick" %% "slick-hikaricp" % "3.2.1",
      "org.postgresql"      % "postgresql"     % "9.4-1206-jdbc4",
      // Logging
      "org.slf4j" % "slf4j-nop" % "1.6.4",
      // Testing
      "com.twitter" %% "finatra-http"   % versions.finatra % "test",
      "com.twitter" %% "inject-server"  % versions.finatra % "test",
      "com.twitter" %% "inject-app"     % versions.finatra % "test",
      "com.twitter" %% "inject-core"    % versions.finatra % "test",
      "com.twitter" %% "inject-modules" % versions.finatra % "test",
      "com.twitter" %% "finatra-http"   % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-server"  % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-app"     % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-core"    % versions.finatra % "test" classifier "tests",
      "com.twitter" %% "inject-modules" % versions.finatra % "test" classifier "tests",
      "org.mockito"    % "mockito-core" % "1.9.5"  % "test",
      "org.scalatest" %% "scalatest"    % "3.0.4"  % "test",
      "org.specs2"    %% "specs2-mock"  % "2.4.17" % "test",
      "com.google.inject.extensions" % "guice-testlib" % versions.guice % "test",
    )
  )
