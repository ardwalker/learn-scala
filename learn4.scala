


// Thanks to 
// - taken from http://blog.originate.com/blog/2014/06/15/idiomatic-scala-your-options-do-not-match/

// All these functions are equivalent to  
//  if (name.isDefined) {  // or nonEmpty
//	  foo 
//  }
//  else { 
//    bar
//  }

class OptionsApp {
}


object OptionsApp extends OptionsApp {

  def main(args: Array[String]) {
  	val name: Option[String] = Option("Andrew")

    println(s"Executing simple option match:  ${option1(name)}")
    println(s"Executing second way:           ${option2(name)}") 
    println(s"Executing idiomatic way:        ${option3(name)}") 
  }

  // Least idiomatic way - most readable?
  def option1(name: Option[String]) = {
	name match {
  	  case Some(n) => foo
  	  case None => bar
	}
  }

  // second way
  def option2(name: Option[String]) = {
	name.map(s => foo).getOrElse(bar)
  }

  // Most idiomatic way - least readable?
  def option3(name: Option[String]) = {
	name.fold(bar)( _ => foo)
  }

  def foo = "Foo"

  def bar = "Bar"
}



