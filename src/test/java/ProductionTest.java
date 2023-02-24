import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductionTest {
    private int add(String s) {
        if (s == null) {
            throw new InvalidParameterException();
        }
        if (s.equals("")) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    @Test
    public void emptyString() {
        assertEquals(0, add(""));
    }

    @Test
    public void oneNumberString() {
        assertEquals(2, add("2"));
    }

    @Test
    public void threeNumberString() {
        assertEquals(3, add("3"));
    }

    @Test
    public void nullString() {
        assertThrows(InvalidParameterException.class, () -> add(null));
    }
}