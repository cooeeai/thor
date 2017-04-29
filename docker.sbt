import sbt.Keys._

enablePlugins(DockerPlugin)

dockerfile in docker := {
  val artifact: File = assembly.value
  val artifactTargetPath = s"/opt/apps/${artifact.name}"
  new Dockerfile {
    from("openjdk:8u121")
    maintainer("https://github.com/markmo")
    workDir("/opt/apps")
    volume("/tmp")
    env("APP_CONFIG", "")
    expose(8080)
    add(artifact, artifactTargetPath)
    entryPointRaw(s"java -jar $artifactTargetPath")
  }
}

imageNames in docker := {
  val imageName = ImageName(s"tbots/${name.value}:latest")
  Seq(imageName, imageName.copy(tag = Some("v" + version.value)))
}
