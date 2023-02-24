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
        if (s.length() <= 2) {
            return Integer.parseInt(s);
        }
        String[] numbers = s.split(",");
        return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
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

    @Test
    public void oneAndTwoReturnThree() {
        assertEquals(3, add("1,2"));
    }

    @Test
    public void twoAndOneReturnThree() {
        assertEquals(3, add("2,1"));
    }

    @Test
    public void fiveAndSixReturnEleven(){
        assertEquals(11, add("5,6"));
    }

    @Test
    public void fiftyFive(){
        assertEquals(55, add("55"));
    }
}