
object examples{
  // Currying

  // ---------------------------------------------
  // normal &  (shorthand) curried function definition
  def        line(a:Int, b:Int, x:Int):Int= a+b*x //> line: (a: Int, b: Int, x: Int)Int
  def curriedline(a:Int)(b:Int)(x:Int):Int= a+b*x //> curriedline: (a: Int)(b: Int)(x: Int)Int

  //  normal vs. curried function calling
  val p1 =        line (1,  2,  3)                //> p1  : Int = 7
  val p2 = curriedline (1) (2) (3)                //> p2  : Int = 7

  // ---------------------------------------------
  // use curried function in higher order function
  def defaultLine(x: Int): Int = curriedline(1)(2)(x)
                                                  //> defaultLine: (x: Int)Int
  val p3 = defaultLine(3)                         //> p3  : Int = 7
  
  // ---------------------------------------------
  // uncurrying / currying exiting functions
  
    val curriedline2 = (line _).curried           //> curriedline2  : Int => (Int => (Int => Int)) = scala.Function3$$Lambda$9/797
                                                  //| 8630@ce8af7
//val recurriedline = Function.curried(line2 _)  is deprecated and no longer works
  
  
    val uncurriedline = Function.uncurried(curriedline _)
                                                  //> uncurriedline  : (Int, Int, Int) => Int = scala.Function$$$Lambda$11/1404192
                                                  //| 2@1ba5a14
  val p4 =        uncurriedline (1,  2,  3)       //> p4  : Int = 7
  val recurrieduncurriedline =  uncurriedline.curried
                                                  //> recurrieduncurriedline  : Int => (Int => (Int => Int)) = scala.Function3$$La
                                                  //| mbda$9/7978630@17a2457


  val p5 =            curriedline2  (1) (2) (3)   //> p5  : Int = 7
  val p6 = recurrieduncurriedline   (1) (2) (3)   //> p6  : Int = 7
  
  // ---------------------------------------------
  // partial function application
  // partial function pf1
  val pf1   = curriedline (1) (2) _               //> pf1  : Int => Int = examples$$$Lambda$16/13469495@f71333

  //  application using one argument
  val pf1_3 = pf1(3)                              //> pf1_3  : Int = 7
  val pf1_2 = pf1(2)                              //> pf1_2  : Int = 5
  // partial function pf2

  val pf2  = curriedline (1) _                    //> pf2  : Int => (Int => Int) = examples$$$Lambda$17/26648510@aa5eb0
  //  application using one argument
  val pf2_23 = pf2(2)(3)                          //> pf2_23  : Int = 7
  val pf2_22 = pf2(2)(2)                          //> pf2_22  : Int = 5

  //----------------------------------------------
  // Partially applied function look similar like currying - but is is significantly different
  def partialLine = (b: Int, x: Int) => line(1, b, x)
                                                  //> partialLine: => (Int, Int) => Int
  val p7 = partialLine(2 , 3)                     //> p7  : Int = 7

  def partialLine_shorthand = line(1, _: Int, _: Int)
                                                  //> partialLine_shorthand: => (Int, Int) => Int
  val p8 = partialLine(2 , 3)                     //> p8  : Int = 7

  // ---------------------------------------------
  // shorthand and longhand notation for curry functions
  def curried_shorthand   (a:Int)   (b:Int): Int= a+b
                                                  //> curried_shorthand: (a: Int)(b: Int)Int
  def curried_longhand    (a:Int) = (b:Int)  => a + b
                                                  //> curried_longhand: (a: Int)Int => Int
  val p9  = curried_shorthand (1) (2)             //> p9  : Int = 3
  val p10 = curried_longhand  (1) (2)             //> p10  : Int = 3

  def curriedline_shorthand(a:Int)   (b:Int)    (x:Int): Int= a+b*x
                                                  //> curriedline_shorthand: (a: Int)(b: Int)(x: Int)Int
  def curriedline_longhand (a:Int) = (b:Int) => (x:Int)    => a + b*x
                                                  //> curriedline_longhand: (a: Int)Int => (Int => Int)

 // def curriedline_longhand1(f: Int => Int  ): (Int, Int) => Int = {_ + _}
  
   val p11 = curriedline_shorthand (1) (2) (3)    //> p11  : Int = 7

   val p12 = curriedline_longhand  (1) (2)(3)     //> p12  : Int = 7

}