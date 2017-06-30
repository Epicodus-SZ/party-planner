import org.junit.*;
import static org.junit.Assert.*;

public class EventTest {

  @Test
    public void newEvent_instantiatesCorrectly() {
      Event testEvent = new Event("test");
      assertEquals(true, testEvent instanceof Event);
    }

  @Test
    public void setGuestCount_isAbleToSetGuestsCount_100() {
      Event testEvent = new Event("test");
      testEvent.setGuestCount(100);
      assertEquals(100, testEvent.getGuestCount());
    }

  @Test
    public void setFood_isAbleToSetFoodOption_Pizza() {
      Event testEvent = new Event("test");
      testEvent.setFood("Pizza");
      assertEquals("Pizza", testEvent.getFood());
    }

  @Test
    public void coupon1IsValid_ReturnsFalsebyDefault_false() {
      Event testEvent = new Event("test");
      assertEquals(false, testEvent.coupon1IsValid());
    }

  @Test
    public void coupon1IsValid_ReturnsFalseWhenGuestsButNoDinner_false() {
      Event testEvent = new Event("test");
      testEvent.setGuestCount(200);
      assertEquals(false, testEvent.coupon1IsValid());
    }

  @Test
    public void coupon1IsValid_ReturnsTrueWhenFullyMet_true() {
      Event testEvent = new Event("test");
      testEvent.setGuestCount(150);
      testEvent.setFood("Pizza");
      assertEquals(true, testEvent.coupon1IsValid());
    }

  @Test
    public void setSubTotal_ReturnsFalseByDefault_false() {
      Event testEvent = new Event("test");
      assertEquals(false, testEvent.coupon2IsValid());
    }

  @Test
    public void setSubTotal_ReturnsTrueWhenFullyMet_true() {
      Event testEvent = new Event("test");
      testEvent.setGuestCount(800);
      testEvent.setFood("Pizza");
      assertEquals(true, testEvent.coupon2IsValid());
    }

  @Test
    public void setSubTotal_SetsmDiscountTo0byDefault_0() {
      Event testEvent = new Event("test");
      assertEquals(String.valueOf(0.0), String.valueOf(testEvent.getDiscounts()));
    }

  @Test
    public void setSubTotal_SetsmDiscountTo200WhenFullyMet_200() {
      Event testEvent = new Event("test");
      testEvent.setGuestCount(400);
      testEvent.setBeverages("wine");
      assertEquals(String.valueOf(200.0), String.valueOf(testEvent.getDiscounts()));
    }


}
