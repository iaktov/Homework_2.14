import org.example.StringList;
import org.example.StringListImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class StringListTest {


    private final StringList actual = new StringListImpl(3);


    @Test
    public void addTest() {
        String expected = "hello";
        actual.add("hello");
        Assertions.assertEquals(expected, actual.get(0));

    }


}
