import java.util.*;
import java.util.Locale;
import java.text.NumberFormat;

public class Event {
  private String mName; //name of event
  private int mGuestCount; //number of guests
  private String mFood; //what food is to be served
  private String mBeverages; //Beverage choice for event
  private String mEntertainment; //what entertainment was chosen for the event
  private double mDiscounts; //any potential discounts
  private double mSubtotal;
  private Boolean mCoupon1;
  private Boolean mCoupon2;
  public HashMap<String,Double> foodOptions = new HashMap<String,Double>();
  public HashMap<String,Double> beverageOptions = new HashMap<String,Double>();

  //test methods, not used in the app
  public double getDiscounts(){
    return mDiscounts;
  }

  public String getEventName(){
    return mName;
  }

  public Boolean coupon2IsValid(){
    return mCoupon2;
  }

  public Boolean coupon1IsValid(){
    return mCoupon1;
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
    setSubTotal();
  }

  public String getBeverages(){
    return mBeverages;
  }

  public void setBeverages(String beverageChoice) {
    mBeverages = beverageChoice;
    setSubTotal();
  }

  public void setSubTotal(){
    //determine subtotal price
    double pricePerHead = foodOptions.get(mFood) + beverageOptions.get(mBeverages);
    double tempSubtotal = pricePerHead*mGuestCount;

    //test for coupon 1
    if(!mFood.equals("none") && mGuestCount>149) {
      mCoupon1 = true;
    } else {
      mCoupon1 = false;
    }

    //test for coupon 2
    if(tempSubtotal>2000.00){
      mCoupon2 = true;
      mDiscounts = 200;
    }
    else {
      mCoupon2 = false;
      mDiscounts = 0;
    }

    mSubtotal = tempSubtotal;
  }

  public double getTotalPrice() {
    //determine total price
    double tempTotal = mSubtotal - mDiscounts;
    return tempTotal;
  }

  public String showMeTheMoney(double number){
    return NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(number);
  }

  public Event(String name){ //Class constructor
    mName = name;
    mSubtotal = 0;
    mFood = "none";
    mGuestCount = 0;
    mBeverages = "none";
    mEntertainment = "none";
    mDiscounts = 0;
    mCoupon1 = false;
    mCoupon2 = false;

    // Configure food options
    foodOptions.put("none", 0.00);
    foodOptions.put("Pizza", 6.50);
    foodOptions.put("Steak", 19.80);
    foodOptions.put("Fruit", 3.00);

    // Configure beverage options
    beverageOptions.put("none", 0.00);
    beverageOptions.put("beer", 4.00);
    beverageOptions.put("wine", 6.00);

  }
}
