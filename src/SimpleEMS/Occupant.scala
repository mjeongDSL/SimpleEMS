package SimpleEMS

/**
 * @author mjeong
 */
class Occupant {
  var name = DEFAULT_NAME;
  
  def setName(newName: String): Unit = {
    name = newName
  }
  
  def getName(): String = {
    name
  }
}