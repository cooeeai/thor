//import AssemblyKeys._

//assemblySettings

//outputPath in assembly := new java.io.File("thor.jar")

//mainClass in assembly := Some("com.rdio.thor.Thor")

//excludedJars in assembly := {
//  val cp = (fullClasspath in assembly).value
//  cp filter {_.data.getName == "scalatest_2.10-2.1.3.jar"}
//}

name := "thor"

organization := "com.rdio"

version := "0.2.3"

scalaVersion := "2.10.5"

sbtVersion := "0.13.13"

scalacOptions ++= Seq(
  "-deprecation"
  //"-target:jvm-1.7"
)

resolvers ++= Seq(
  "Twitter Maven repo" at "http://maven.twttr.com/",
  "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "com.sksamuel.scrimage" %% "scrimage-core" % "2.1.7" exclude("org.slf4j", "slf4j-log4j12"),
  "com.sksamuel.scrimage" %% "scrimage-filters" % "2.1.7" exclude("org.slf4j", "slf4j-log4j12"),
  "com.twitter" %% "finagle-http" % "6.6.2",
  "com.typesafe" % "config" % "1.3.1",
  "org.apache.httpcomponents" % "httpclient" % "4.5.3",
  "org.scalatest" % "scalatest_2.10" % "2.1.3" % "test"
)

org.scalastyle.sbt.ScalastylePlugin.Settings
