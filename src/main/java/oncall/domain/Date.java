package oncall.domain;

import static oncall.consts.Calender.getLastDate;
import static oncall.consts.Error.INVALID_MESSAGE;

import oncall.consts.Calender;

public class Date {
    private static final int JANUARY = 1;
    private static final int DECEMBER = 12;
    private final int month;
    private int date;

    public Date(int month, int date) {
        validateMonth(month);
        this.month = month;
        this.date = date;
    }

    private void validateMonth(int month) {
        if (!validateMonthRange(month)) {
            INVALID_MESSAGE.throwException();
        }
    }

    private boolean validateMonthRange(int month) {
        return JANUARY <= month && DECEMBER >= month;
    }

    public boolean updateDay() {
        if (getLastDate(month) <= date) {
            return false;
        }
        ++date;
        return true;
    }

    public boolean isHoliday() {
        return Calender.isHoliday(this);
    }

    public int getMonth() {
        return month;
    }

    public int getDate() {
        return date;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Date otherDate = (Date) obj;
        return month == otherDate.getMonth() && date == otherDate.getDate();
    }

    @Override
    public String toString() {
        return month + "월" + " " + date + "일";
    }
}
