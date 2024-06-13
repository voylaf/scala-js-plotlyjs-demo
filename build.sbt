name := "scala-js-plotlyjs-demo"

scalaVersion := "2.13.14"
crossScalaVersions := Seq("2.13")

val poltlyjsVersion = "1.6.2"
val scaladgetVersion = "1.9.4"
// scaladget 1.9.4 conflicts with laminar 15+
val laminarVersion = "0.14.2"

resolvers += Resolver.jcenterRepo

lazy val runDemo = taskKey[Unit]("runDemo")

lazy val demo = project.in(file(".")) enablePlugins (ScalaJSBundlerPlugin, JSDependenciesPlugin) settings(
  libraryDependencies += "org.scala-js" %%% "scalajs-dom" % "2.8.0",
  libraryDependencies += "com.raquo" %%% "laminar" % laminarVersion,
  libraryDependencies += "org.openmole.scaladget" %%% "bootstrapnative" % scaladgetVersion,
  libraryDependencies += "org.openmole.scaladget" %%% "highlightjs" % scaladgetVersion,
  libraryDependencies += "org.openmole.scaladget" %%% "svg" % scaladgetVersion,
  libraryDependencies += "org.openmole" %%% "scala-js-plotlyjs" % poltlyjsVersion ,
  libraryDependencies += "com.lihaoyi" %%% "sourcecode" % "0.4.2",
  scalaJSUseMainModuleInitializer := true,
  jsDependencies += "org.webjars.npm" % "plotly.js-dist" % "2.27.1" / "2.27.1/plotly.js",
  webpack / version := "5.91.0",
  webpackCliVersion := "5.1.4",
  startWebpackDevServer / version := "4.15.1",
  runDemo := {
    val demoResource = (Compile / resourceDirectory).value
    val jsBuild = (Compile / fastOptJS / webpack ).value.head.data

    IO.copyFile(jsBuild, target.value / "js/demoplotly.js")
    IO.copyFile(crossTarget.value / s"${name.value}-jsdeps.js", target.value / "js/deps.js")
    IO.copyDirectory(demoResource, target.value)
  }

)
