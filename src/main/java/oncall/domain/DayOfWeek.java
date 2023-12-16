package oncall.domain;

public class DayOfWeek {
    private String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void updateNextDay() {
        if (dayOfWeek.equals("월")) {
            dayOfWeek = "화";
        } else if (dayOfWeek.equals("화")) {
            dayOfWeek = "수";
        } else if (dayOfWeek.equals("수")) {
            dayOfWeek = "목";
        } else if (dayOfWeek.equals("목")) {
            dayOfWeek = "금";
        } else if (dayOfWeek.equals("금")) {
            dayOfWeek = "토";
        } else if (dayOfWeek.equals("토")) {
            dayOfWeek = "일";
        } else if (dayOfWeek.equals("일")) {
            dayOfWeek = "월";
        }
    }

    public boolean isWeekend() {
        return dayOfWeek.equals("일") || dayOfWeek.equals("토");
    }

    public boolean isWeekday() {
        return !isWeekend();
    }

    @Override
    public String toString() {
        return dayOfWeek;
    }
}
