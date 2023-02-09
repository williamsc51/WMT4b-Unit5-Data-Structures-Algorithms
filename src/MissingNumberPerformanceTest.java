import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MissingNumberPerformanceTest {
    List<Integer> missingNone = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

    List<Integer> missingEight = new ArrayList<>(List.of(1,2,3,4,5,6,7,9,10));
    private int max = 10;
    private MissingNumber mn = new MissingNumber();

    @Test(timeout=100)
    public void testMissingNumber_Performance() {
        for (int i = 0; i < 1000000; i += 1) {
            mn.missingNum(missingNone, max);
            mn.missingNum(missingEight, max);
        }
    }
}