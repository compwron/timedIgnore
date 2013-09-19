import org.joda.time.DateTime;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

public class TimedIgnoreTest {

    @Test
    public void shouldRunBecauseAssumptionHasTimedOut() {
        runOnDateBecause("2012-01-01", "todays date is past 2012");
        fail("See message from runOnDateBecause");
    }

    @Test
    public void shouldNotRunBefore2020BecauseAssumptionHasNotTimedOut() {
        runOnDateBecause("2020-01-01", "today's date is past 2020-01-01");
        fail("See message from runOnDateBecause");
    }

    private void runOnDateBecause(String date, String reasonToStartRunning) {
        if (new DateTime().isAfter(new DateTime(date))) { // May have to replace this with non-Joda date parsing in older codebases
//            Logger.log("Running test because " + reasonToStartRunning);
            System.out.println("Running test because " + reasonToStartRunning);
        } else {
            assumeTrue(false);
        }
    }
}
