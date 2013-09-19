import org.joda.time.DateTime;

import static org.junit.Assume.assumeTrue;

public class TestHelper {
    static void runAfterDateBecause(String date, String reasonToStartRunning) {
        if (new DateTime().isAfter(new DateTime(date))) { // May have to replace this with non-Joda date parsing in older codebases
//            Logger.log("Running test because " + reasonToStartRunning);
            System.out.println("Running test because " + reasonToStartRunning);
        } else {
            assumeTrue(false);
        }
    }
}
