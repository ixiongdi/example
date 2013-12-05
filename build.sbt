seq(Revolver.settings: _*)

name := "hello"

version := "1.0"

scalaVersion := "2.10.2"

libraryDependencies ++= Seq(
	"org.eclipse.jetty" % "jetty-servlet" % "9.1.0.v20131115",
    "org.glassfish.grizzly" % "grizzly-http-server" % "2.3.7",
    "io.undertow" % "undertow-core" % "1.0.0.Beta22",
    "io.undertow" % "undertow-servlet" % "1.0.0.Beta22"
)

scalariformSettings