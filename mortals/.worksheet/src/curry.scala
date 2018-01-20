object curry {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(65); 
  
  
  def        line(a: Int, b: Int, x: Int): Int = a * b + x;System.out.println("""line: (a: Int, b: Int, x: Int)Int""");$skip(59); 
  def curriedline(a: Int)(b: Int)(x: Int): Int = a * b + x;System.out.println("""curriedline: (a: Int)(b: Int)(x: Int)Int""");$skip(30); 
  

  val l   =   line(1,2,3);System.out.println("""l  : Int = """ + $show(l ));$skip(30); 
  val lc  =   curriedLine(1)(;System.out.println("""lc  : <error> = """ + $show(lc ))}

  
}
