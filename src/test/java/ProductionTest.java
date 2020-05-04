import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ProductionTest {

    @Test
    public void stupidTest(){
        assertThat(true, is(true));
    }
}
