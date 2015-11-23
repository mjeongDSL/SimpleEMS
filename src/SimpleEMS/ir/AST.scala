package simpleEMS.ir

/**
 * @author mjeong
 */

import simpleEMS.ir.WeekDay._

sealed abstract class AST

/** Queries **/
sealed abstract class Qry extends AST
case class Query(statement: Stmt, filter: Filter) extends Qry

/** Statements **/
sealed abstract class Stmt extends AST
case class Reserve(room: Thing) extends Stmt
case class Find(day: WeekDay.Value) extends Stmt
case class Get(str: String) extends Stmt

/** Filters **/
sealed abstract class Filter extends AST
case class Block(filters: Seq[Filter]) extends Filter
case class Between(time: Int) extends Filter
case class After(time: Int) extends Filter
case class Before(time: Int) extends Filter
case class In(building: Building) extends Filter

/** Things **/
sealed abstract class Thing extends AST
case class Room(roomname: String) extends Thing
case class Building(buildingname: String) extends Thing
case class Time(hour: Int, quarterHour: Int) extends Thing
















