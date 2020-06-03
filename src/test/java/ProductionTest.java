import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.fail;


public class ProductionTest {

    @Test
    public void emptyString() {
        assertThat(Calculator.Add(""), is(0));
    }

    @Test
    public void withOneAsString() {
        assertThat(Calculator.Add("1"), is(1));
    }

    @Test
    public void withTwoAsString() {
        assertThat(Calculator.Add("2"), is(2));
    }

    @Test
    public void withOneAndTwoAsString() {
        assertThat(Calculator.Add("1,2"), is(3));
    }

    @Test
    public void withOneAndTwoAndThreeAsString() {
        assertThat(Calculator.Add("1,2,3"), is(6));
    }

    @Test
    public void withOneAndTwoAndThreeWithNewLineAndCommaAsSeparators() {
        assertThat(Calculator.Add("1\n2,3"), is(6));
    }

    @Test
    public void semicolonAsDelimiter() {
        assertThat(Calculator.Add("//;\n1;2"), is(3));
    }

    @Test
    public void oneNegativeNumber() {

        try {
            Calculator.Add("-1");
            fail();

        } catch (InvalidParameterException e) {
            assertThat(e.getMessage(), is("negatives not allowed, -1"));
        }
    }
}
