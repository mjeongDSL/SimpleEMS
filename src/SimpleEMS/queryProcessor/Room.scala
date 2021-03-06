package simpleEMS.queryProcessor

/**
 * @author mjeong
*/
import simpleEMS.queryProcessor.Schedule._
import simpleEMS.ir.WeekDay._
import simpleEMS.queryProcessor.Schedule

class Room(roomname: String, buildingname: String)  {
  val days = Array.fill[Schedule](7)(new Schedule())
 
  def isFree(hour: Int, endHour: Int, day: WeekDay.Value): Boolean = {
    days(day.id).isFree(hour, endHour)
  }
  
  def getScheduleforDay(day: WeekDay.Value): Schedule = {
    new Schedule() //placeholder
  }
  
}

object Room {
  
}