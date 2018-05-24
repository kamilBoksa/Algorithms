import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayFlattererTest {
    private ArrayFlatterer flatterer;

    @Before
    public void setUp(){
        flatterer = new ArrayFlatterer();
    }

    @Test
    public void testGetFlattenList_SingleDimensionalList() {
        Object[] input = {1, 2, 3, new Object[]{4, 5}};
        Object[] expected = {1,2,3,4,5};
        Object[] actual = flatterer.getFlattenList(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetFlattenList_MultidimensionalList() {
        Object[] input = {1, 3, new Object[]{"age", 5}, "Kraków", new Object[]{1, new Object[]{3,
                          new Object[]{4,5}, "codecool"}}, 6, 7};
        Object[] expected = new Object[] {1, 3, "age", 5, "Kraków", 1, 3, 4, 5, "codecool", 6, 7};
        Object[] actual = flatterer.getFlattenList(input);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testGetFlattenList_ReturnNull() {
        Object[] actual = flatterer.getFlattenList(null);
        assertNull(actual);
    }
}