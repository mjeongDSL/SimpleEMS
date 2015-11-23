package simpleEMS.interpreter

/**
 * @author mjeong
*/

import simpleEMS.interpreter.Schedule._
import simpleEMS.interpreter.Room._

class RoomManager {
  /*
   * Contains rooms and handles external API calls
   */
  
  val mRooms = scala.collection.mutable.HashMap.empty[String, Room]
  
  def makeNewRoom(roomName: String): Unit = {
    mRooms += (roomName -> new Room("\n", "\n"))
  }
  
  def getSchedule (roomName: String, day: WeekDay.Value): Schedule = {
    mRooms(roomName).getScheduleforDay(day)
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