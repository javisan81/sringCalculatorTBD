import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;


public class ProductionTest {
    private int add(String s) {
        if(s.equals("")){
            return 0;
        }
        return 2;
    }

    @Test
    public void emptyString(){
        assertEquals(0, add(""));
    }

   @Test
    public void oneNumberString(){
        assertEquals(2, add("2"));
   }


}
