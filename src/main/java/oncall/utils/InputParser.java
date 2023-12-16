package oncall.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import oncall.domain.Worker;

public class InputParser {
    private static final String COMMA = ",";
    InputValidator inputValidator = new InputValidator();

    public Map<Integer, String> parseMonthAndDayOfWeek(String input) {
        input = removeSpaces(input);
        List<String> data = split(input);
        inputValidator.validateMonthAndDayOfWeek(split(input));
        Map<Integer, String> parsed = new HashMap<>();
        parsed.put(Integer.parseInt(data.get(0)), data.get(1));
        return parsed;
    }

    public List<Worker> parseWorkingOrder(String input) {
        input = removeSpaces(input);
        inputValidator.validateWorkingOrderInput(input);
        List<String> data = split(input);
        return data.stream()
                .map(Worker::new)
                .toList();
    }

    public List<String> split(String input) {
        return Arrays.stream(input.split(COMMA)).toList();
    }

    private String removeSpaces(String input) {
        return input.replaceAll(" ", "");
    }
}
