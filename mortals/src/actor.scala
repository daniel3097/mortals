

object actor extends App {
  

def        line(a: Int, b: Int, x: Int): Int = a * x + b
def curriedLine(a: Int)(b: Int)(x: Int): Int = line(a, b, x)

def defaultLine(x: Int): Int = curriedLine(1)(0)(x)

println(defaultLine(5)) // returns `5`
  
def sum(a: Int)(b: Int) = a + b

println(sum(4)(9) )
  
  
}
  
  
