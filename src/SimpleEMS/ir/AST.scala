package simpleEMS.ir

/**
 * @author mjeong
 */

import simpleEMS.ir.Room._

sealed abstract class AST

/** Statements **/
sealed abstract class Stmt extends AST
case class Block(filters: Seq[Filter]) extends Stmt
case class Reserve(room: Room) extends Stmt
case class Find() extends Stmt
case class Get(str: String) extends Stmt

/** Joint **/
sealed abstract class Joint extends AST
case class AddFilter(left: Stmt, right: Filter) extends Joint

/** Filters **/
sealed abstract class Filter extends AST
case class Between(time: Int) extends Filter
case class After(time: Int) extends Filter
case class Before(time: Int) extends Filter
case class In(building: String) extends Filter










