import org.junit.*;
import static org.junit.Assert.*;

public class EventTest {

  @Test
    public void newEvent_instantiatesCorrectly() {
      Event testEvent = new Event();
      assertEquals(true, testEvent instanceof Event);
    }

  @Test
    public void setGuests_isAbleToSetGuestsCount_100() {
      Event testEvent = new Event();
      testEvent.setGuests(100);
      assertEquals(100, testEvent.getGuests());
    }

}
