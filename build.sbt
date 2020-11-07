name := """real-estate-sales-contract-management-system"""
organization := "com.example"

//version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
  "org.typelevel"          %% "cats-core"          % "2.0.0",
  "eu.timepit"             %% "refined"            % "0.9.13",
  "io.estatico"            %% "newtype"            % "0.4.4"
)

/**
 * @see: https://github.com/estatico/scala-newtype
 * Install For newtype
 */
//addCompilerPlugin("org.scalamacros" % "paradise" % "2.12.8" cross CrossVersion.full)
addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.0" cross CrossVersion.full)

scalacOptions ++= Seq(
  "-Xfatal-warnings",
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:existentials",
  "-language:higherKinds",
  "-language:implicitConversions",
  "-Ywarn-dead-code",
  "-Ymacro-annotations",
)

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

import ReleaseTransformations._

releaseVersionBump := sbtrelease.Version.Bump.Bugfix

skip in publish := true

releaseProcess := Seq[ReleaseStep](
  inquireVersions,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  releaseStepCommandAndRemaining("publish"),
  setNextVersion,
  commitNextVersion,
  pushChanges
)
