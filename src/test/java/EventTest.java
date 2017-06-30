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

}
