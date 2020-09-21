import java.io.{BufferedWriter, FileWriter}

import scala.io.Source

object codehandler {

  def main(args: Array[String]): Unit = {

    def handleFile(filename:String, output:String): Unit ={

      var saveNext:Boolean = false
      val writer = new BufferedWriter(new FileWriter(output))

      for (line <- Source.fromFile(filename).getLines) {

        if (saveNext && line.length > 0){
          writer.write(line + '\n' + "<|endoftext|>" + '\n')
          saveNext = false
        }

        else if (line.length > 0){
          if (line(0) == '['){
            saveNext = true
          }
        }

      }
      writer.close()
    }

    handleFile("general.txt", "output.txt")
    handleFile("kingboop.txt", "output.txt")
    handleFile("pearphonemms.txt", "output.txt")
    handleFile("programming.txt", "output.txt")
    handleFile("politics.txt", "output.txt")
  }

}
