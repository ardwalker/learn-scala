
import scala.util.{Try, Failure, Success}
import scala.concurrent.Future

class TryApp {
}


object TryApp extends TryApp {

  def main(args: Array[String]) {
    println(s"Executing try1:  ${try1}")
    println(s"Executing try2:  ${try2}")
    // println(s"Executing second way:           ${option2(name)}") 
    // println(s"Executing idiomatic way:        ${option3(name)}") 
  }

  // Least idiomatic way - most readable?
  def try1 = {
    val t1 = Try(somethingBad)
    t1 match {
      case Success(_) => "woohoo1"
      case Failure(e) => e.getMessage
    }
  }

  def try2 = {
    val t2 = Try(somethingAsyncBad)
    t2 match {
      case Success(_) => "woohoo2"
      case Failure(e) => e.getMessage
    }
  }


  def somethingBad = {
    throw new Exception("Something crappy happened")
  }

  def somethingAsyncBad = {
    Future.successful {
      Thread.sleep(1000);
      throw new Exception("Something async crappy happened")
    }
  }
}



