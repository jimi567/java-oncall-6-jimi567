package oncall.service;

import java.util.ArrayList;
import java.util.List;
import oncall.domain.Date;
import oncall.domain.DayOfWeek;
import oncall.domain.Worker;
import oncall.domain.WorkingOrder;

public class OnCallService {

    private final Date date;
    private final DayOfWeek dayOfWeek;
    private final WorkingOrder weekdayOrder;
    private final WorkingOrder weekendOrder;

    List<Worker> order = new ArrayList<>();
    List<String> schedule = new ArrayList<>();

    public OnCallService(Date date, DayOfWeek dayOfWeek, WorkingOrder weekdayOrder, WorkingOrder weekendOrder) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.weekdayOrder = weekdayOrder;
        this.weekendOrder = weekendOrder;
    }

    public List<String> getSchedule() {
        do {
            if (dayOfWeek.isWeekday() && date.isHoliday()) {
                addScheduleHoliday();
            } else if (dayOfWeek.isWeekday()) {
                addScheduleWeekday();
            } else if (dayOfWeek.isWeekend()) {
                addScheduleWeekend();
            }
            dayOfWeek.updateNextDay();
        } while (date.updateDay());
        return schedule;
    }

    private void addScheduleHoliday() {
        if (sameWorkerPrevious(weekendOrder.getNextWorker())) {
            weekendOrder.updateNextWorker();
        }
        order.add(weekendOrder.getNextWorker());
        schedule.add(date + " " + dayOfWeek + "(휴일) " + weekendOrder.getNextWorker());
        weekendOrder.updateNextWorker();
    }

    private void addScheduleWeekday() {
        if (sameWorkerPrevious(weekdayOrder.getNextWorker())) {
            weekdayOrder.updateNextWorker();
        }
        order.add(weekdayOrder.getNextWorker());
        schedule.add(
                date + " " + dayOfWeek + " " + weekdayOrder.getNextWorker());
        weekdayOrder.updateNextWorker();
    }

    private void addScheduleWeekend() {
        if (sameWorkerPrevious(weekendOrder.getNextWorker())) {
            weekendOrder.updateNextWorker();
        }
        order.add(weekendOrder.getNextWorker());
        schedule.add(date + " " + dayOfWeek + " " + weekendOrder.getNextWorker());
        weekendOrder.updateNextWorker();
    }

    private boolean sameWorkerPrevious(Worker worker) {
        return getLastWorker(order) == worker;
    }

    public Worker getLastWorker(List<Worker> order) {
        if (order.size() == 0) {
            return null;
        }
        return order.get(order.size() - 1);
    }

}
