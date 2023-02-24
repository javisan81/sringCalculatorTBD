import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


public class ProductionTest {
    private int add(String s) {
        return 0;
    }

    @Test
    public void emptyString(){
        assertEquals(0, add(""));
    }


}
