object example_1a_curry {

  
  
  def        line(a: Int, b: Int, x: Int): Int = a * b + x
                                                  //> line: (a: Int, b: Int, x: Int)Int
  def curriedline(a: Int)(b: Int)(x: Int): Int = a * b + x
                                                  //> curriedline: (a: Int)(b: Int)(x: Int)Int

}