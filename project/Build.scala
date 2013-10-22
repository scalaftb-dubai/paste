import sbt._
import Keys._
import play.Project

object ApplicationBuild extends Build {

  val appName         = "paste"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.webjars" %% "webjars-play" % "2.2.0",
    "org.webjars" % "bootstrap" % "2.3.2",
    "org.webjars" % "flat-ui" % "bcaf2de95e",
    "org.webjars" % "jquery-ui" % "1.10.3",
    "org.webjars" % "jquery-ui-touch-punch" % "0.2.2-1"
  )

  val main = Project(appName, appVersion, appDependencies).settings(
  )

}
