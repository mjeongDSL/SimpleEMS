package SimpleEMS

/**
 * @author mjeong
*/
import simpleEMS.ir.Schedule._
import simpleEMS.ir.Weekday._

class Room  {
  val days = Array.fill[Schedule](7)(new Schedule());
  def isFree(hour: Int, endHour: Int, day: Weekday): Boolean = {
    days[day].isFree(hour, endHour)
  }
  
  def getScheduleforDay(day: String, dayEnd: String): Schedule = {
    Schedule()
  }
}

object Room {
  
}