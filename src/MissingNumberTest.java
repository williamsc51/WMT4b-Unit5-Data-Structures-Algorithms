import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MissingNumberTest {
    List<Integer> missingMax = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9));
    List<Integer> missingNone = new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10));

    List<Integer> missingEight = new ArrayList<>(List.of(1,2,3,4,5,6,7,9,10));
    private MissingNumber mn = new MissingNumber();

    @Test
    public void testMissingNumber_NoneMissing() {
        assertEquals(0, mn.missingNum(missingNone, 10));
    }

    @Test
    public void testMissingNumber_MissingSeven() {
        assertEquals(8, mn.missingNum(missingEight, 10));
    }


}