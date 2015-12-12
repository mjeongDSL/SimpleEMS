package simpleEMS.parser

import scala.language.postfixOps
import scala.util.parsing.combinator.JavaTokenParsers
import scala.util.parsing.combinator.PackratParsers
import simpleEMS.ir._

object SimpleEMSParser extends JavaTokenParsers with PackratParsers {

    // parsing interface
    def apply(s: String): ParseResult[AST] = {
      parseAll(descriptor, s)
    }
    
    lazy val descriptor: PackratParser[Descriptor] =
      ( "room"~"{"~multiDFields~"}" ^^ {case "room"~"{"~f~"}" => new room(f)}
      | "reserve"~"{"~multiQFields~"}" ^^ {case "reserve"~"{"~f~"}" => new reserve(f)}
      | "find"~"{"~multiQFields~"}" ^^ {case "find"~"{"~f~"}" => new find(f)}
      )
      
      // For now, they are parsed the same way but this way semantics can handle them different
    lazy val multiDFields: PackratParser[DescriptionFields] =
      ( singleField~";"~multiDFields ^^ {case f~";"~fs => new MultipleDescriptionFields(f, fs)}
      | singleField~";" ^^ {case f~";" => new SingleDescriptionFields(f)}
      )
    
    lazy val multiQFields: PackratParser[QueryFields] =
      ( singleField~";"~multiQFields ^^ {case f~";"~fs => new MultipleQueryFields(f, fs)}
      | singleField~";" ^^ {case f~";" => new SingleQueryFields(f)}
      )
    
    lazy val singleField: PackratParser[Field] =
      ( string~":"~data ^^ {case s~":"~d => new SomeField(s, d)}
      )
      
    lazy val data: PackratParser[Data] =
      ( datum~","~data ^^ {case d~":"~dt => new MultipleDatum(d, dt)}
      | datum~"-"~datum ^^ {case dL~":"~dR => new RangeDatum(dL, dR)}
      | datum ^^ {case d => new SingleDatum(d)}
      )
      
    lazy val datum: PackratParser[Datum] =
      ( "'"~string~"'" ^^ {case "'"~s~"'" => new StringDatum(s)}
      | int ^^ {case i => new IntDatum(i)}
      | int~"/"~int~"/"~int ^^ {case d~"/"~m~"/"~y => new DateDatum(d, m, y)}
     // | weekday ^^ {case w => new WeekdayDatum(w)}
      )

    // Capture primitives
    def string: Parser[String] = """(\w+-*)+""".r
    def int: Parser[Int] = int ^^ {i => i.toInt}
    }
