import java.util.*;

public class Event {
  private String mName; //name of event
  private int mGuestCount; //number of guests
  private String mFood; //what food is to be served
  private String mBeverages; //Beverage choice for event
  private String mEntertainment; //what entertainment was chosen for the event
  private double mDiscounts; //any potential discounts
  public HashMap<String,Double> foodOptions = new HashMap<String,Double>();
  public HashMap<String,Double> beverageOptions = new HashMap<String,Double>();


  public String getEventName(){
    return mName;
  }

  //free DJ if Dinner + guests > 149
  public Boolean coupon1IsValid(){
    if(!mFood.equals("none") && mGuestCount>149) {
      return true;
    } else {
      return false;
    }
  }

  //$200 off events over $2000
  public Boolean coupon2IsValid(){
    if(getTotalPrice()>2000.00){
      return true;
    }
    else {
      return false;
    }
  }

  public int getGuestCount(){
    return mGuestCount;
  }

  public void setGuestCount(int guests) {
    mGuestCount = guests;
  }

  public String getFood(){
    return mFood;
  }

  public void setFood(String foodChoice) {
    mFood = foodChoice;
  }

  public double getTotalPrice() {
    //determine total price
    double totalPrice = (foodOptions.get(mFood)*mGuestCount)-mDiscounts;
    return totalPrice;
  }

  public Event(String name){ //Class constructor
    mName = name;
    mFood = "none";
    mGuestCount = 0;
    mBeverages = "none";
    mEntertainment = "none";
    mDiscounts = 0;

    // Configure food options
    foodOptions.put("none", 0.00);
    foodOptions.put("Pizza", 6.50);
    foodOptions.put("Steak", 19.80);
    foodOptions.put("Fruit", 3.00);

    // Configure food options
    beverageOptions.put("none", 0.00);
    beverageOptions.put("beer", 4.00);
    beverageOptions.put("wine", 6.00);

  }
}
