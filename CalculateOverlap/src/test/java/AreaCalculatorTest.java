import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AreaCalculatorTest {

    AreaCalculator areaCalculator;

    @Before
    public void setUp() {
        areaCalculator = new AreaCalculator();
    }

    @Test
    public void calculateRectangleArea_shouldReturnProperSingleRectangleArea() {

        int expected = 4;
        int actual = areaCalculator.calculateRectangleArea(-2,4,-4,2);
        assertEquals(expected, actual);
    }

    @Test
    public void calculateOverlap_oneRectangleIntoAnother() {
        int expected = 36;
        int actual = areaCalculator.calculateOverlap(10,10,-1,-1,3,9,-1,0);
        assertEquals(expected, actual);
        }

    @Test
    public void calculateOverlap_partOfOneRectangleIntoAnotherHorizontally() {
        int expected = 16;
        int actual = areaCalculator.calculateOverlap(5,8,1,2,6,7,-4,3);
        assertEquals(expected,actual);
    }

    @Test
    public void calculateOverlap_partOfOneRectangleIntoAnotherVertically() {
        int expected = 9;
        int actual = areaCalculator.calculateOverlap(3,6,-3,-6,1,8,-2,3);
        assertEquals(expected,actual);
    }

    @Test
    public void calculateOverlap_noCommonPartShouldReturnZero() {
        int expected = 0;
        int actual = areaCalculator.calculateOverlap(-12, -4, -1, -2, 0, 0, 100, 3000);
        assertEquals(expected,actual);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateOverlap_throwExceptionIfCalculatedAreaBeyondIntegerValue() {
        areaCalculator.calculateOverlap(2147483647,2147483647, -2147483648, -2147483648, 2147483645, 2147483645, -2147483645, -2147483645);
    }
    }
