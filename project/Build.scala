import sbt._
import Keys._
import play.Project

object ApplicationBuild extends Build {

  val appName = "paste"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "org.webjars" %% "webjars-play" % "2.2.0",
    "org.webjars" % "bootstrap" % "2.3.2",
    "org.webjars" % "flat-ui" % "bcaf2de95e",
    "org.webjars" % "jquery-ui" % "1.10.3",
    "org.webjars" % "jquery-ui-touch-punch" % "0.2.2-1",
    "com.sksamuel.elastic4s" % "elastic4s_2.10" % "0.90.5.2" //
    )

  val main = play.Project(appName, appVersion, appDependencies).settings( //
  //repositories needed for "com.clever-age" % "play2-elasticsearch" % "0.8-SNAPSHOT"
  //    resolvers += Resolver.url("play-plugin-releases", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/"))(Resolver.ivyStylePatterns),
  //    resolvers += Resolver.url("play-plugin-snapshots", new URL("http://repo.scala-sbt.org/scalasbt/sbt-plugin-snapshots/"))(Resolver.ivyStylePatterns)
  )

}
