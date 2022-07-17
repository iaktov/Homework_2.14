import org.example.StringList;
import org.example.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringListTest {


    private final StringList actual = new StringListImpl(3);


    @Test
    public void addTest() {
        String expected = "hello";
        actual.add("hello");
        Assertions.assertEquals(expected, actual.get(0));

    }


}
