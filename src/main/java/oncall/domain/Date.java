package oncall.domain;

import static oncall.consts.Calender.getLastDate;

import oncall.consts.Calender;

public class Date {
    private final int month;
    private int date;

    public Date(int month, int date) {
        this.month = month;
        this.date = date;
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
        return month == otherDate.month && date == otherDate.date;
    }

    @Override
    public String toString() {
        return month + "월" + " " + date + "일";
    }
}
