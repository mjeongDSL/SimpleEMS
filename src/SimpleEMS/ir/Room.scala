package simpleEMS.ir

/**
 * @author mjeong
*/
import simpleEMS.ir.Schedule._
import simpleEMS.ir.WeekDay._

class Room  {
  val days = Array.fill[Schedule](7)(new Schedule())
  var Building = "Shan"
  def isFree(hour: Int, endHour: Int, day: WeekDay.Value): Boolean = {
    days(day.id).isFree(hour, endHour)
  }
  
  def getScheduleforDay(day: WeekDay.Value, dayEnd: WeekDay.Value): Schedule = {
    new Schedule() //placeholder
  }
  
}

object Room {
  
}