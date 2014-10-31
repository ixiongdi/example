seq(Revolver.settings: _*)

name := "hello"

version := "1.0"

scalaVersion := "2.11.2"

libraryDependencies ++= Seq(
	"org.eclipse.jetty" % "jetty-servlet" % "9.2.3.v20140905",
    "org.glassfish.grizzly" % "grizzly-http-server" % "2.3.17",
    "io.undertow" % "undertow-core" % "1.2.0.Beta3",
    "io.undertow" % "undertow-servlet" % "1.2.0.Beta3"
)

// scalariformSettings

