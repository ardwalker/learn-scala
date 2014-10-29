
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try



class Learn6App {
}

// Uses a partial function to replace a specific handler in map/flatMap recover

object Learn6App extends Learn6App {

  // Try permits recovery from exceptions at any point in the chain
  // Recover can be used on each execution line, or defer recovery to the end of the comprehension
  def main(args: Array[String]) {
  	println(s"Calling exec1: $exec1")
  	println(s"Calling exec2: $exec2")
  	println(s"Calling exec3: $exec3")
  }

  def exec1 = {
  	Try(execute.map(m => m)).recover(handleErrors)
  }

  def exec2 = {
	for {
		r1 <- Try(execute).map(m => m).recover (handleErrors)
 	} yield {
		r1	
	} 
  }

  def exec3 = {
  	Try(execute.map(m => m))
  }


  def execute: Future[Option[String]] = {
    Future.successful ({
      Thread.sleep(1000);
      throw new Exception("Something async crappy happened")
      Option("whatever return from execute")
    })
  }

  private def handleErrors: PartialFunction[Throwable,String] = {
    case t: Throwable => println("in handleErrors"); "handleErrors"
  }

}





