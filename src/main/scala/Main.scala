import org.scalatest.funsuite.AnyFunSuite

//Assumptions : the orders list will contain menu items only

class coffeeShopTesting extends AnyFunSuite{
  var cafe = new coffeeShop;


  test("Test 1") {
    var bill: List[String] =List("Cola", "Coffee", "Cheese Sandwich")
    assert(cafe.totalBill(bill) === 3.5)
  }
  test("Test 2") {
    var bill: List[String] =List("Cola", "Steak Sandwich", "Cheese Sandwich" , "Coffee")
    assert(cafe.totalBill(bill) === 8.0)
  }
  test("Test 3") {
    var bill: List[String] =List("Cola")
    assert(cafe.totalBill(bill) === 0.5)
  }

  test("Test 4") {
    var bill: List[String] =List("Cheese Sandwich" ,"Cheese Sandwich")
    assert(cafe.totalBill(bill) === 4.0)
  }
}

class coffeeShop{

  val menu = Map("Cola" -> ("Cold",0.50),
    "Coffee"-> ("Hot",1.0),
    "Cheese Sandwich"-> ("Cold",2.0),
    "Steak Sandwich"-> ("Hot",4.50))

  def totalBill(items : List[String]  ) : Double ={
    var billSum=0.0

    if(items.nonEmpty)
      items.foreach(billSum +=menu(_)._2)
    println(billSum)
    billSum
  }

}

object Main
