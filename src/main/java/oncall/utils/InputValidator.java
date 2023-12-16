package oncall.utils;

import static oncall.consts.Error.INVALID_MESSAGE;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {

    private final Pattern pattern = Pattern.compile("\"^[가-힣a-zA-Z]+(,[가-힣a-zA-Z]+)*$\"");
    private final List<String> dayOfWeeks = List.of("월", "화", "수", "목", "금", "토", "일");

    public void validateMonthAndDayOfWeek(List<String> input) {
        if (input.size() != 2) {
            INVALID_MESSAGE.throwException();
            return;
        }
        validateMonth(input.get(0));
        validateDayOfWeek(input.get(1));
    }

    private void validateMonth(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            INVALID_MESSAGE.throwException();
        }
    }

    private void validateDayOfWeek(String input) {
        if (!dayOfWeeks.contains(input)) {
            INVALID_MESSAGE.throwException();
        }
    }

    public void validateWorkingOrderInput(String input) {
        if (isValidFormat(input)) {
            INVALID_MESSAGE.throwException();
        }
    }

    private boolean isValidFormat(String input) {
        return pattern.matcher(input).matches();
    }
}
