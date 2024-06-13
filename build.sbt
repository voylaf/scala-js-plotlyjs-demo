name := "scala-js-plotlyjs-demo"

scalaVersion := "2.13.14"

val poltlyjsVersion = "1.6.2"
val scaladgetVersion = "1.9.4"
val laminarVersion = "17.0.0"

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
  runDemo := {
    val demoResource = (Compile / resourceDirectory).value
    val jsBuild = (Compile / fastOptJS / webpack ).value.head.data

    IO.copyFile(jsBuild, target.value / "js/demoplotly.js")
    IO.copyDirectory(demoResource, target.value)
  }

)
