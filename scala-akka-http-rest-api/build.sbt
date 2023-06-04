ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

lazy val root = (project in file("."))
  .settings(
    name := "scala-akka-http-rest-api",
    idePackagePrefix := Some("moteex.com")
  )

val AkkaVersion = "2.8.0"
val AkkaHttpVersion = "10.5.2"
val akka = Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion
)

val scalaLogging = Seq(
  "ch.qos.logback" % "logback-classic" % "1.4.6",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5"
)

val circeVersion = "0.14.5"
val scalaJson = Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  // heikoseeberger supposed to (un)marshal from/to JSON
  "de.heikoseeberger" %% "akka-http-circe" % "1.39.2",
)

libraryDependencies ++= scalaLogging ++ akka ++ scalaJson