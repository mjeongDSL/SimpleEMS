package SimpleEMS

/**
 * @author mjeong
 */
class Room  {
  val days = Array.fill[Schedule](7)(Schedule());

  def isFree(hour: Int, endHour: Int, day: Weekday): Boolean = {
    days[day].isFree(hour, endHour)
  }
  
  def getScheduleforDay(day: String, dayEnd: String): Schedule = {
    Schedule()
  }
}