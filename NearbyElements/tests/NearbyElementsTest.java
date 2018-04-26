import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NearbyElementsTest {
    private NearbyElements nearbyElements;

    @Before
    public void setUp() {
        nearbyElements = new NearbyElements();
    }

    @Test
    public void testNearbyElements_FirstArrayThirdElementRangeTwo() {
        int[] expected = {2,0,1241,12};
        int[] actual = nearbyElements.nearby(0,2,2);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_SecondArrayFirstElementRangeOne() {
        int[] expected = {3};
        int[] actual = nearbyElements.nearby(1,0,1);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_SecondArrayFourthElementRangeFive() {
        int[] expected = {1,3,5};
        int[] actual = nearbyElements.nearby(1,3,5);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_FirstArrayLastElementRangeFour() {
        int[] expected = {1110, -42, 424, 1};
        int[] actual = nearbyElements.nearby(0,11,4);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_FirstArrayFirstElementRangeThree() {
        int[] expected = {0, 4, 1241};
        int[] actual = nearbyElements.nearby(0,0,3);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_SecondArrayThirdElementRangeOne() {
        int[] expected = {3, 7};
        int[] actual = nearbyElements.nearby(1, 2, 1);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_SecondArrayFourthElementRangeTwo() {
        int[] expected = {3,5};
        int[] actual = nearbyElements.nearby(1,3,2);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_ThirdArrayFirstElementRangeFive() {
        int[] expected = {320, 32, 3, 41241, -11};
        int[] actual = nearbyElements.nearby(2,0, 5);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_ThirdArrayTenthElementRangeFour() {
        int[] expected = {-11, -12, -13, -66};
        int[] actual = nearbyElements.nearby(2,9, 4);
        assertArrayEquals(expected,actual);
    }

    @Test
    public void testNearbyElements_ThirdArrayFifthElementRangeThree() {
        int[] expected = {320,32, 3, -11, -12, -13};
        int[] actual = nearbyElements.nearby(2,4, 3);
        assertArrayEquals(expected,actual);
    }
}
