import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TinkerTailorTest {

    @Test
    public void testFindTheWinner_returnFiveElementList() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        TinkerTailor tt = new TinkerTailor(3, numbers);
        int expected = 5;
        int actual = tt.findTheWinner().size();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetWinner_returnCorrectWinner() {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        TinkerTailor tt = new TinkerTailor(3, numbers);
        Integer expected = 4;
        tt.findTheWinner();
        Integer actual = tt.getWinner();
        assertEquals(expected, actual);
    }
}