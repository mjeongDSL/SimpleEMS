package simpleEMS.semantics

import simpleEMS.ir._

/**
 * DescriptorInterpreter can interpret descriptors
 */
class DescriptorInterpreter {
  
  /** evaluating a descriptor **/
  def eval(ast: AST): Map[String, scala.collection.mutable.MutableList[Any]] = {
    ast match {
      case room(fields: DescriptionFields) => {
        evalDFields(fields)
      }
      case reserve(fields: QueryFields) => {
        evalQFields(fields)
      }
      case find(fields: QueryFields) => {
        evalQFields(fields)
      }
    }
  }

  /** evaluating query fields **/
  def evalQFields(ast: QueryFields): Map[String, scala.collection.mutable.MutableList[Any]] = {
    ast match {
      case MultipleQueryFields(field, rest) => {
        evalQFields(rest).+(evalField(field))
      }
      case SingleQueryFields(field) => {
        Map(evalField(field))
      }
    }
  }
  
  /** evaluating description fields **/
  def evalDFields(ast: DescriptionFields): Map[String, scala.collection.mutable.MutableList[Any]] = {
    ast match {
      case MultipleDescriptionFields(field, rest) => {
        evalDFields(rest).+(evalField(field))
      }
      case SingleDescriptionFields(field) => {
        Map(evalField(field))
      }
    }
  }
  
  /** evaluating fields **/
  def evalField(ast: Field): (String, scala.collection.mutable.MutableList[Any]) = {
    ast match {
      case SomeField(fieldName, data) => {
        (fieldName, evalData(data))
      }
    }
  }
  
  /** evaluating field data **/
  def evalData(ast: Data): scala.collection.mutable.MutableList[Any] = {
    ast match {
      case MultipleDatum(datum, rest) => {
        evalData(rest).+=:(evalDatum(datum))
      }
      case RangeDatum(startDatum, endDatum) => {
        scala.collection.mutable.MutableList(evalDatum(startDatum), evalDatum(endDatum))
      }
      case SingleDatum(datum: Datum) => {
        scala.collection.mutable.MutableList(evalDatum(datum))
      }
    }
  }
  
  /** evaluating singletons **/
  def evalDatum(ast: Datum) = {
    ast match {
      case StringDatum(value) => {
        value
      }
      case IntDatum(value) => {
        value
      }
      // For now, represent dates as a simple tuple
      case DateDatum(m, d, y) => {
        (m, d, y)
      }
    }
  }
}