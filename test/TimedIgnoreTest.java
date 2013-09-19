import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class TimedIgnoreTest {

    @Test
    public void shouldRunBecauseAssumptionHasTimedOut() {
        TestHelper.runAfterDateBecause("2012-01-01", "the date today is past 2012");
        assertTrue(true);
    }

    @Test
    public void shouldNotRunBefore2020BecauseAssumptionHasNotTimedOut() {
        TestHelper.runAfterDateBecause("2020-01-01", "the date today is past 2020-01-01");
        assertTrue(true);
    }

    @Test
    public void shouldRunBecauseInvalidDateIsPassed() {
        TestHelper.runAfterDateBecause("invalid date", "the date today is past given date (which is invalid)");
        assertTrue(true);
    }


}
