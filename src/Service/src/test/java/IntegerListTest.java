import org.example.IntegerList;
import org.example.IntegerListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class IntegerListTest {
    private final IntegerList actual = new IntegerListImpl(3);

    @Test
    public void addTest() {
        Integer expected = 1;
        actual.add(1);
        Assertions.assertEquals(expected, actual.get(0));
    }

    @Test
    public void addWithIndexTest() {
        Integer expected = 1;
        actual.add(0, 1);
        Assertions.assertEquals(expected, actual.get(0));
    }

    @Test
    public void containsTest() {
        Boolean expected = true;
        actual.add(0, 1);
        actual.add(1, 2);
        Assertions.assertEquals(true, actual.contains(2));
    }

    @Test
    public void sortedTest() {
        Integer[] expected = new Integer[]{1, 2, 3};
        actual.add(0, 1);
        actual.add(1, 3);
        actual.add(2, 2);
        actual.contains(2);
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual.toArray()));
    }

    @Test
    public void addOverFlowTest() {
        Integer[] expected = new Integer[]{1, 2, 3, 4};
        actual.add(0, 1);
        actual.add(1, 3);
        actual.add(2, 2);
        actual.add(3, 4);
        actual.contains(2);
        Assertions.assertEquals(Arrays.toString(expected), Arrays.toString(actual.toArray()));
    }

    @Test
    public void sizeTest() {
        int expected = 1;
        actual.add(1);
        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    public void clearTest() {
        int expected = 0;
        actual.add(1);
        actual.clear();
        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    public void indexOfTest() {
        Integer expected = 0;
        actual.add(1);
        Assertions.assertEquals(expected, actual.indexOf(1));
    }

    @Test
    public void lastIndexOfTest() {
        Integer expected = 2;
        actual.add(1);
        actual.add(1);
        actual.add(1);
        Assertions.assertEquals(expected, actual.lastIndexOf(1));
    }
}
