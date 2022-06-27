import org.scalatest.funsuite.AnyFunSuite

//Assumptions : the orders list will contain menu items only

class coffeeShopTesting extends AnyFunSuite{
  var cafe = new coffeeShop;

  test("Test 1") {
    val bill: List[String] =List("Cola", "Coffee", "Cheese Sandwich")
    assert(cafe.functionalTotalBill(bill) === 3.85)
  }
  test("Test 2") {
    val bill: List[String] =List("Cola", "Steak Sandwich", "Cheese Sandwich" , "Coffee")
    assert(cafe.functionalTotalBill(bill) === 9.6)
  }
  test("Test 3") {
    val bill: List[String] =List("Cola")
    assert(cafe.functionalTotalBill(bill) === 0.5)
  }

  test("Test 4") {
    val bill: List[String] =List("Cheese Sandwich" ,"Cheese Sandwich")
    assert(cafe.functionalTotalBill(bill) === 4.4)
  }

  test("Test 5") {
    val bill: List[String] =List("Steak Sandwich" ,"Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich")
    assert(cafe.functionalTotalBill(bill) === 32.4)
  }
}

class coffeeShop{

  val menu = Map("Cola" -> ("Cold",0.50,"Drink"),
    "Coffee"-> ("Hot",1.0,"Drink"),
    "Cheese Sandwich"-> ("Cold",2.0,"Food"),
    "Steak Sandwich"-> ("Hot",4.50,"Food"))


  def functionalTotalBill(items : List[String]  ) : Double ={
    val billSum =items.map(S => menu(S)._2).sum

    val hasFood=items.map(S =>  menu(S)._3).contains("Food")

    val hasHotFood=items.map(S => (menu(S)._1, menu(S)._3)).contains(("Hot", "Food"))

    val serviceCharge = if (hasHotFood) Math.min(0.2*billSum,20.0) else if (hasFood) Math.min(0.1*billSum,20.0) else 0

    // round to 2 decimal places
    val TotalBillSum= (Math.round((billSum+serviceCharge)*100)/100.0)

    TotalBillSum
  }

}

object Main
