import org.scalatest.funsuite.AnyFunSuite

//Assumptions : the orders list will contain menu items only

class coffeeShopTesting extends AnyFunSuite{
  var cafe = new coffeeShop;

  test("Test 1") {
    var bill: List[String] =List("Cola", "Coffee", "Cheese Sandwich")
    assert(cafe.totalBill(bill) === 3.85)
  }
  test("Test 2") {
    var bill: List[String] =List("Cola", "Steak Sandwich", "Cheese Sandwich" , "Coffee")
    assert(cafe.totalBill(bill) === 9.6)
  }
  test("Test 3") {
    var bill: List[String] =List("Cola")
    assert(cafe.totalBill(bill) === 0.5)
  }

  test("Test 4") {
    var bill: List[String] =List("Cheese Sandwich" ,"Cheese Sandwich")
    assert(cafe.totalBill(bill) === 4.4)
  }

  test("Test 5") {
    var bill: List[String] =List("Steak Sandwich" ,"Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich","Steak Sandwich")
    assert(cafe.totalBill(bill) === 32.4)
  }
}

class coffeeShop{

  val menu = Map("Cola" -> ("Cold",0.50,"Drink"),
    "Coffee"-> ("Hot",1.0,"Drink"),
    "Cheese Sandwich"-> ("Cold",2.0,"Food"),
    "Steak Sandwich"-> ("Hot",4.50,"Food"))

  def totalBill(items : List[String]  ) : Double ={
    var billSum=0.0
    var serviceCharge=0.0
    var hasFood=false
    var hasHotFood=false

    for(item <- items){
      if(menu(item)._3.compareTo("Food") == 0 && menu(item)._1.compareTo("Hot") == 0)
        hasHotFood=true;
      else if(menu(item)._3.compareTo("Food") ==0)
        hasFood=true;

      billSum +=menu(item)._2
    }
    if(hasHotFood)
      serviceCharge=billSum*0.20;
    else if(hasFood)
      serviceCharge=billSum*0.10;

    serviceCharge =Math.min(serviceCharge,20.0);
    billSum+=serviceCharge

    // round to 2 decimal places
    billSum= (Math.round(billSum*100)/100.0)

    billSum
  }

}

object Main
