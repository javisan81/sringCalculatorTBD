import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ProductionTest {


    @Test
    public void emptyString(){
        assertThat(Add(""), is(0));
    }

    @Test
    public void withOneAsString(){
        assertThat(Add("1"), is(1));
    }

    @Test
    public void withTwoAsString(){
        assertThat(Add("2"), is(2));
    }

    @Test
    public void withOneAndTwoAsString(){
        assertThat(Add("1,2"), is(3));
    }

    private int Add(String numbers) {
        if(numbers.equals(""))
            return 0;
        return Arrays.stream(numbers.split(","))
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
