import java.io.Console;
import java.util.Locale;
import java.text.NumberFormat;

public class App {

  public static void main(String[] args) {
    String userInput;
    Console myConsole = System.console();
    System.out.println("What is the name of your event?");
    userInput = myConsole.readLine();
    Event myEvent = new Event(userInput);

    do {
      System.out.println("-----------------------------------------------");
      System.out.println("Name:" + myEvent.getEventName());
      System.out.println("Guests:" + myEvent.getGuestCount());
      System.out.println("Food Option:" + myEvent.getFood());
      System.out.println("Beverages Option:" + myEvent.getBeverages());
      System.out.println("Monthly Specials---");
      if(myEvent.coupon1IsValid()){
        System.out.println("*** Free DJ w/ 150+ Guests and meals *** ($200 value!)");
      }
      if(myEvent.coupon2IsValid()){
        System.out.println("*** $200 Off all Parties over $2000 ***");
      }
      System.out.println("Total Price:" + myEvent.showMeTheMoney(myEvent.getTotalPrice()));

      System.out.println("\n\nSet Event options:\n# of [G]uests, [F]ood, [B]everages, E[X]it");
      userInput = myConsole.readLine().toUpperCase();

      switch (userInput) {
        case "G": //setting guests was chosen
          System.out.println("How many guests?");
          userInput = myConsole.readLine();
          myEvent.setGuestCount(Integer.parseInt(userInput));
          myEvent.setSubTotal();
          break;
        case "F":
          myEvent.foodOptions.forEach((k,v) ->{
            System.out.println(k + "- " + myEvent.showMeTheMoney(v));
          });
          System.out.println("What food would you like?");
          userInput = myConsole.readLine();
          myEvent.setFood(userInput);
          break;
        case "B":
          myEvent.beverageOptions.forEach((k,v) ->{
            System.out.println(k + "- " + myEvent.showMeTheMoney(v));
          });
          System.out.println("What beverage would you like?");
          userInput = myConsole.readLine();
          myEvent.setBeverages(userInput);
          break;
        case "X":
          System.out.println("goodbye");
          break;
      }
    } while (!userInput.equals("X"));
  }
}
