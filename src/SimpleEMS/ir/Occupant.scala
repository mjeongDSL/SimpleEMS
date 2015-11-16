package simpleEMS.ir

/**
 * @author mjeong
 */

class Occupant {
  var name = "\n"
  
  def setName(newName: String): Unit = {
    name = newName
  }
  
  def getName(): String = {
    name
  }
}

object Occupant {
  
}