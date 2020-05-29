import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


public class ProductionTest {


    @Test
    public void emptyString() {
        assertThat(Add(""), is(0));
    }

    @Test
    public void withOneAsString() {
        assertThat(Add("1"), is(1));
    }

    @Test
    public void withTwoAsString() {
        assertThat(Add("2"), is(2));
    }

    @Test
    public void withOneAndTwoAsString() {
        assertThat(Add("1,2"), is(3));
    }

    @Test
    public void withOneAndTwoAndThreeAsString() {
        assertThat(Add("1,2,3"), is(6));
    }

    @Test
    public void withOneAndTwoAndThreeWithNewLineAndCommaAsSeparators() {
        assertThat(Add("1\n2,3"), is(6));
    }

    @Test
    public void semicolonAsDelimiter() {
        assertThat(Add("//;\n1;2"), is(3));
    }

    private int Add(String numbers) {
        if (numbers.equals(""))
            return 0;
        String delimiter = ",";
        String onlyNumbers = numbers;
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
            onlyNumbers = numbers.substring(4);
        }
        return Stream.of(onlyNumbers.split("[" + delimiter + "\n]")).mapToInt(Integer::parseInt).sum();
    }
}
