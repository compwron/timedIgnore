import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class TimedIgnoreTest {
    @Before
    public void setUp() {
        new ClasspathScanner().scan();
    }

    @TimedIgnore(expires = "2012-01-01")
    @Test
    public void shouldNotIgnore() {
        fail("this test should fail because it is not ignored");
    }

    @TimedIgnore(expires = "2020-01-01")
    @Test
    public void shouldIgnore() {
        fail("this test should not fail because it is ignored until 2020");
    }

}
