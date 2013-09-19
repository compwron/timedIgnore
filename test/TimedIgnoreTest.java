import org.junit.Test;

import static org.junit.Assert.fail;

public class TimedIgnoreTest {

    @Test
    public void shouldRunBecauseAssumptionHasTimedOut() {
        TestHelper.runAfterDateBecause("2012-01-01", "todays date is past 2012");
        fail("See message from runAfterDateBecause");
    }

    @Test
    public void shouldNotRunBefore2020BecauseAssumptionHasNotTimedOut() {
        TestHelper.runAfterDateBecause("2020-01-01", "today's date is past 2020-01-01");
        fail("See message from runAfterDateBecause");
    }


}
