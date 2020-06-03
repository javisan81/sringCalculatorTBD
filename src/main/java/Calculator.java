import java.security.InvalidParameterException;
import java.util.stream.Stream;

public class Calculator {
    public static int Add(String numbers) {
        if (numbers.equals(""))
            return 0;

        if (numbers.startsWith("-"))
            throw new InvalidParameterException("negatives not allowed, " + numbers);

        return Stream.of(parseNumbers(numbers)).mapToInt(Integer::parseInt).sum();
    }

    private static String[] parseNumbers(String numbers) {
        String delimiter = ",";
        String onlyNumbers = numbers;
        if (numbers.startsWith("//")) {
            delimiter = numbers.substring(2, 3);
            onlyNumbers = numbers.substring(4);
        }
        return onlyNumbers.split("[" + delimiter + "\n]");
    }
}
