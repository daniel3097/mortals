
object example_curry{
  // ---------------------------------------------
  // normal &  (shorthand) curried function definition
  def        line(a:Int, b:Int, x:Int):Int= a+b*x //> line: (a: Int, b: Int, x: Int)Int
  def curriedline(a:Int)(b:Int)(x:Int):Int= a+b*x //> curriedline: (a: Int)(b: Int)(x: Int)Int

  //  normal vs. curried function calling
  val p1 =        line (1,  2,  3)                //> p1  : Int = 7
  val p2 = curriedline (1) (2) (3)                //> p2  : Int = 7

  // ---------------------------------------------
  // uncurrying / currying exiting functions
  val line2 = Function.uncurried(curriedline _)   //> line2  : (Int, Int, Int) => Int = scala.Function$$$Lambda$9/13535991@1684286
                                                  //| 
  val p3 =        line2 (1,  2,  3)               //> p3  : Int = 7
  val recurriedline =  line2.curried              //> recurriedline  : Int => (Int => (Int => Int)) = scala.Function3$$Lambda$12/4
                                                  //| 370598@f82f98
//val recurriedline = Function.curried(line2 _)  is deprecated and no longer works
  val p4 = recurriedline (1) (2) (3)              //> p4  : Int = 7

  // ---------------------------------------------
  // partial function application
  // partial function pf1
  val pf1   = curriedline (1) (2) _               //> pf1  : Int => Int = example_curry$$$Lambda$15/6780589@108b2d7

  //  application using one argument
  val pf1_3 = pf1(3)                              //> pf1_3  : Int = 7
  val pf1_2 = pf1(2)                              //> pf1_2  : Int = 5
  // partial function pf2

  val pf2  = curriedline (1) _                    //> pf2  : Int => (Int => Int) = example_curry$$$Lambda$16/22319259@1f256fa
  //  application using one argument
  val pf2_23 = pf2(2)(3)                          //> pf2_23  : Int = 7
  val pf2_22 = pf2(2)(2)                          //> pf2_22  : Int = 5
  // ---------------------------------------------



}