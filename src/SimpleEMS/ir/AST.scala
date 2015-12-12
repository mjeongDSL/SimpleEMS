package simpleEMS.ir

/**
 * @author mjeong
 */

import simpleEMS.ir.WeekDay._

sealed abstract class AST

/** Descriptors **/
sealed abstract class Descriptor extends AST
case class room(fields: DescriptionFields) extends Descriptor
case class reserve(fields: QueryFields) extends Descriptor
case class find(fields: QueryFields) extends Descriptor

/** Multiple Fields **/
sealed abstract class QueryFields extends AST
case class MultipleQueryFields(field: Field, rest: QueryFields) extends QueryFields
case class SingleQueryFields(field: Field) extends QueryFields

sealed abstract class DescriptionFields extends AST
case class MultipleDescriptionFields(field: Field, rest: DescriptionFields) extends DescriptionFields
case class SingleDescriptionFields(field: Field) extends DescriptionFields

/** Single Field **/
sealed abstract class Field extends AST
case class SomeField(fieldName: String, data: Data) extends Field

/** Multiple Fields, Ranges and lists **/
sealed abstract class Data extends AST
case class MultipleDatum(datum: Datum, rest: Data) extends Data
case class RangeDatum(startDatum: Datum, endDatum: Datum) extends Data
case class SingleDatum(datum: Datum) extends Data

/** Types handling **/
sealed abstract class Datum extends AST
case class StringDatum(value: String) extends Datum
case class IntDatum(value: Int) extends Datum
case class DateDatum(month: Int, day: Int, year: Int) extends Datum
//case class WeekdayDatum(weekday: WeekDay) extends Datum


