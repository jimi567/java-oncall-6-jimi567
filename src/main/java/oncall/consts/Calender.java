package oncall.consts;

import java.util.List;
import java.util.stream.IntStream;
import oncall.domain.Date;

public enum Calender {

    MONTH_31(IntStream.rangeClosed(1, 31).boxed().toList()),
    MONTH_30(IntStream.rangeClosed(1, 30).boxed().toList()),
    MONTH_28(IntStream.rangeClosed(1, 28).boxed().toList());

    private static List<Integer> MONTHS_31 = List.of(1, 3, 5, 7, 8, 10, 12);
    private static final List<Integer> MONTHS_30 = List.of(4, 6, 9, 11);

    private static final List<Date> HOLIDAY = List.of(
            new Date(1, 1), new Date(3, 1), new Date(5, 5), new Date(6, 6), new Date(8, 15), new Date(10, 3),
            new Date(10, 9), new Date(12, 25)
    );


    private final List<Integer> days;

    Calender(List<Integer> days) {
        this.days = days;
    }

    public List<Integer> getDays() {
        return days;
    }

    public static int getLastDate(int month) {
        if (month == 2) {
            return 28;
        } else if (MONTHS_31.contains(month)) {
            return 31;
        }
        return 30;
    }

    public static boolean isHoliday(Date date) {
        return HOLIDAY.contains(date);
    }
}
