package SimpleEMS

/**
 * @author mjeong
 */

// Looking for a way to remove global val
val DEFAULT_NAME = "\n"

class Schedule {
  /**
   * The schedule for a day
   */
  val hourly = Array.fill[Occupant](24)(Occupant());
  
  def setOccupant(hour: Int, endHour: Int, occ: Occupant): Unit = {
    for(int i = hour; i < endHour; i++) {
      hourly[i] = occ
    }
  }
  
  def isFree(hour: Int, endHour: Int): Boolean = {
    for(int i = hour; i < endHour; i++) {
      if(hourly(i).getName() != DEFAULT_NAME) {
        return false
      }
    }
    true
  }
}