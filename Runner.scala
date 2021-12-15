import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor

import java.io.InputStream
import scala.util.Try

object Runner extends App {

  println("Test")
/**
 * 1 Yaml = 1 Job = 1 .py or .xml
 * 1 Yaml = 1 or more tasks
 * */

  import org.yaml.snakeyaml.Yaml
  import java.io.InputStream



  case class TaskParsed(run_this_query: String, dialect: String)
  case class JobParsed(name: String, description: String, tasks: List[TaskParsed], runnerType: String)

  def readYamlConfigFile(path: String):JobParsed = {
    val yaml = new Yaml(new Constructor(classOf[JobParsed]))
    val inputStream: InputStream = this.getClass.getClassLoader.getResourceAsStream(path)
    yaml.load(inputStream)
  }


  trait Job
  case class AirFlowJob(name: String, script:String) extends Job

  def generateRunnerScript(job: JobParsed): AirFlowJob = {
    /**
     * Use Template for generating py code
     *
     * */
    AirFlowJob("test", "someCode")
  }

  def writeScriptToFile(job: Job) = {

    Try(/*Write job.script with job.name*/)
      .recover{

    }
  }









}