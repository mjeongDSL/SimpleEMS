package simpleEMS.ir

/**
 * @author mjeong
*/

import simpleEMS.ir.Schedule._
import simpleEMS.ir.Room._

class RoomManager {
  /*
   * Contains rooms and handles external API calls
   */
  
  val mRooms = scala.collection.mutable.HashMap.empty[String, Room]
  
  def makeNewRoom(roomName: String): Unit = {
    mRooms += (roomName -> new Room())
  }
  
  def getSchedule (roomName: String, day: WeekDay.Value, dayEnd: WeekDay.Value): Schedule = {
    mRooms(roomName).getScheduleforDay(day, dayEnd)
  }
    
  def getAvailableRooms (hour: Int, endHour: Int, day: WeekDay.Value): Seq[Room] = { 
    val rooms = Array.empty[Room]
    for ((k, v) <- mRooms) {
      if(v.isFree(hour, endHour, day)){
        rooms :+ v
      }
    }
    return rooms
  }
  
}