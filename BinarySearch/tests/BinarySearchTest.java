import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {

    private BinarySearch binarySearch;

    @Before
    public void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    public void testSearch_sortedArrayShouldReturnTrue() {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertTrue(binarySearch.search(numbers, 3));
    }

    @Test
    public void testSearch_sortedArrayShouldReturnFalse() {
        int[] numbers = new int[] {1, 2, 3, 4, 5, 6, 7};
        assertFalse(binarySearch.search(numbers, 9));
    }

    @Test
    public void testSearch_unsortedArrayShouldReturnTrue() {
        int[] numbers = new int[] {22, 30, 1, 4, 19, 2};
        assertTrue(binarySearch.search(numbers, 4));
    }

    @Test
    public void testSearch_unsortedArrayShouldReturnFalse() {
        int[] numbers = new int[] {22, 30, 1, 4, 19, 2};
        assertFalse(binarySearch.search(numbers, 44));
    }
}