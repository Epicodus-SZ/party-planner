public class Event {
  private String mName; //name of event
  private int mGuestCount; //number of guests
  private String mFood; //what food is to be served
  private String mBeverages; //Beverage choice for event
  private String mEntertainment; //what entertainment was chosen for the event

  public void setGuestCount(int guests) {
    mGuestCount = guests;
  }

  public int getGuestCount(){
    return mGuestCount;
  }

  public void setFood(String foodChoice) {
    mFood = foodChoice;
  }

  public String getFood(){
    return mFood;
  }

  public Event(String name){ //Class constructor
    mName = name;
  }
}
