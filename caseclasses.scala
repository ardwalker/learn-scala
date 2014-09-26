

/** 'Modifying' firstName attribute of a case class 
 * Case classes include a copy method to recreate the object with a new version of that attribute
 */

case class Person(firstName: String, lastName: String) {
  def withFirstName(fn: String) = copy(firstName = fn)
}

