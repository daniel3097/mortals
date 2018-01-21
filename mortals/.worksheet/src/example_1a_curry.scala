object example_1a_curry {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(91); 

  
  
  def        line(a: Int, b: Int, x: Int): Int = a * b + x;System.out.println("""line: (a: Int, b: Int, x: Int)Int""");$skip(59); 
  def curriedline(a: Int)(b: Int)(x: Int): Int = a * b + x;System.out.println("""curriedline: (a: Int)(b: Int)(x: Int)Int""")}
  


  
}
