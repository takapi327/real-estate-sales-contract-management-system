name         := """real-estate-sales-contract-management-system"""
organization := "com.example"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.3"

libraryDependencies ++= Seq(
  guice,
  "org.scalatestplus.play" %% "scalatestplus-play"   % "5.1.0",
  "org.scalactic"          %% "scalactic"            % "3.2.2",
  "org.scalatest"          %% "scalatest"            % "3.2.2",
  "org.typelevel"          %% "cats-core"            % "2.0.0",
  "eu.timepit"             %% "refined"              % "0.9.13",
  "be.venneborg"           %% "slick-refined"        % "0.5.0",
  "io.estatico"            %% "newtype"              % "0.4.4",
  "mysql"                  %  "mysql-connector-java" % "8.0.12",
  "com.typesafe.play"      %% "play-slick"           % "5.0.0"
)

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
