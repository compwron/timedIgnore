import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assume.assumeTrue;

public class TestHelper {

//    Remove usage of this method if the date today is after the runAfter date
    static void runAfterDateBecause(String runAfter, String reasonToStartRunning) {
        if (givenDateIsAfterCurrentDate(runAfter)) {
            System.out.println("Running test because " + reasonToStartRunning + " ...If this test passes, please delete the runAfterDateBecause usage");
        } else {
            System.out.println("Skipping test because run date is in the future: " + runAfter);
            assumeTrue(false);
        }
    }

    private static boolean givenDateIsAfterCurrentDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date givenDate = null;
        try {
            givenDate = format.parse(date);
        } catch (ParseException e) {
            System.out.println("Could not parse date, returning true so that test will run");
            return true;
        }
        return new Date().after(givenDate);

//        return new DateTime().isAfter(new DateTime(date)); // it's easier when using Joda
    }
}
