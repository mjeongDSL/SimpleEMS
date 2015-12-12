package simpleEMS.queryProcessor

/**
 * @author mjeong
 */

import simpleEMS._
import simpleEMS.ir._
import simpleEMS.semantics._
import simpleEMS.parser._

object Control extends DescriptorInterpreter {
  /* Simple way to pass a textfile to parser */
  def main(args: Array[String]) = {
    val program = args(0)
    var lines = scala.io.Source.fromFile(program).mkString
    println(SimpleEMSParser(lines).toString())
  }
}