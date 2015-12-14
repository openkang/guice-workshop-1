organization := "learningakka"

name := "learning-akka"

version := "0.1-SNAPSHOT"

scalaVersion := "2.11.7"

resolvers ++= Seq(
  "Typesafe repository releases" at "http://repo.typesafe.com/typesafe/releases/",
  "Sonatype Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/",
  "snapshots" at "http://oss.sonatype.org/content/repositories/snapshots",
  "releases" at "http://oss.sonatype.org/content/repositories/releases",
  "spray nightlies repo" at "http://nightlies.spray.io"
)

libraryDependencies ++= Seq(
  "net.codingwell" %% "scala-guice" % "4.0.0",
  "com.google.inject" % "guice" % "4.0"
)

scalacOptions += "-feature"