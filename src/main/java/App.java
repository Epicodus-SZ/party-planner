import java.io.Console;

public class App {

  public static void main(String[] args) {
    String userInput;
    Console myConsole = System.console();
    System.out.println("What is the name of your event?");
    userInput = myConsole.readLine();
    Event myEvent = new Event(userInput);

    do {
      System.out.println("Name:" + myEvent.getEventName());
      System.out.println("Guests:" + myEvent.getGuestCount());
      System.out.println("Food Option:" + myEvent.getFood());
      System.out.println("Total Price:" + myEvent.getTotalPrice());
      System.out.println("Monthly Specials---");

      if(myEvent.coupon1IsValid()){
        System.out.println("cou1 yeah");
      }
      if(myEvent.coupon2IsValid()){
        System.out.println("cou2 yeah");
      }
      System.out.println("\n\nSet Event options:\n[G] Set Guest Count\n[F] Set Food Option\n[B] Set Beverage\n[E] Set Entertainment\n[C] Apply Coupon\n[D] Get Event Details\n[X] Exit & Price");
      userInput = myConsole.readLine().toUpperCase();

      switch (userInput) {
        case "G": //setting guests was chosen
          System.out.println("How many guests?");
          userInput = myConsole.readLine();
          myEvent.setGuestCount(Integer.parseInt(userInput));
          break;
        case "F":
          System.out.println("What food would you like?");
          myEvent.foodOptions.forEach((k,v) ->{
            System.out.println(k + "- $" + v);
          });
          userInput = myConsole.readLine();
          myEvent.setFood(userInput);
          break;
        case "B":
          System.out.println("you create a new event");
          break;
        case "E":
          System.out.println("you create a new event");
          break;
        case "C":
          System.out.println("you set food");
          break;
        case "D":
          System.out.println("you set food");
          break;
        case "X":
          System.out.println("goodbye");
          break;
      }
    } while (!userInput.equals("X"));
  }
}
