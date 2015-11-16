package simpleEMS.parser

import scala.language.postfixOps
import scala.util.parsing.combinator.JavaTokenParsers
import scala.util.parsing.combinator.PackratParsers
import simpleEMS.ir._

/**
 * The parser accepts the following language

                n ∈ ℤ     f, x ∈ Name

        s ∈ Stmt ::= `print` e | s `;` s
                  |  `if0` `(` e `)` `then` `{` s `}` `else` `{` s `}`      
                  |  `var` x `:=` e | x `:=` e
                  |  `def` f `(` x `)` `:=` `{` s `}` | f `(` e `)`
        
        e ∈ Expr ::= n | x | e op e | `(` e `)`
        
        op ∈ Operator ::= `+` | `-` | `*` | `/`

 * The parser ignores whitespace. 
 * ℤ is parsed using JavaTokenParsers' wholeNumber parser.
 * Name is parsed using JavaTokenParsers' ident parser.
 */
object SimpleEMSParser extends JavaTokenParsers with PackratParsers {

    // parsing interface
    def apply(s: String): ParseResult[Stmt] = parseAll(stmt, s)

    /** statements **/
    lazy val stmt: PackratParser[Stmt] = 
      (   rep1sep(stmt, ";") ^^ Block 
        | "var"~variable~":="~expr ^^ {case "var"~x~":="~e ⇒ x |←| e} 
        | variable~":="~expr ^^ {case x~":="~e ⇒ x |:=| e}           
        | "print"~>expr ^^ Print
        | ifStmt
        | funcDef
        | call        
        | failure("expected a statement"))
        
    // if stmts
    def ifStmt: Parser[If0] =
      "if0"~"("~expr~")"~"then"~"{"~stmt~"}"~"else"~"{"~stmt~"}" ^^
         { case "if0"~"("~c~")"~"then"~"{"~t~"}"~"else"~"{"~f~"}" ⇒ If0(c,t,f) }

    // function definitions
    def funcDef: Parser[FuncDef] =
     "def"~variable~"("~paramList~")"~":="~"{"~stmt~"}" ^^ 
       { case "def"~f~"("~params~")"~":="~"{"~b~"}" ⇒ FuncDef(f, params, b) } 
   
    def paramList: Parser[List[Var]] = repsep(variable, ",")        
        
    // function calls
    def call: Parser[Call] = 
      variable~"("~argList~")" ^^  {case f~"("~args~")" ⇒ Call(f, args)}
    
    def argList: Parser[List[Expr]] = repsep(expr, ",")          
    
    /** expressions **/
    lazy val expr: PackratParser[Expr] = 
      (   expr~"+"~term ^^ {case l~"+"~r ⇒ l |+| r}
        | expr~"-"~term ^^ {case l~"-"~r ⇒ l |-| r}
        | term )

    // terms
    lazy val term: PackratParser[Expr] = 
      (  term~"*"~fact ^^ {case l~"*"~r ⇒ l |*| r}
       | term~"/"~fact ^^ {case l~"/"~r ⇒ l |/| r}
       | fact )
        
    // factors
    lazy val fact: PackratParser[Expr] =
      (   number
        | variable
        | "("~>expr<~")" 
        | failure("expected an expression"))
        
    // variables
    def variable: Parser[Var] = ident ^^ Var

    // numbers
    def number: Parser[Num] = wholeNumber ^^ {s ⇒ Num(s.toInt)}
 }
