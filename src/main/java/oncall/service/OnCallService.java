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

    public OnCallService(Date date, DayOfWeek dayOfWeek, WorkingOrder weekdayOrder, WorkingOrder weekendOrder) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.weekdayOrder = weekdayOrder;
        this.weekendOrder = weekendOrder;
    }

    public List<String> getSchedule() {
        List<String> schedule = new ArrayList<>();
        do {
            if (dayOfWeek.isWeekday() && date.isHoliday()) {
                if (sameWorkerPrevious(weekendOrder.getNextWorker())) {
                    weekendOrder.updateNextWorker();
                }
                order.add(weekendOrder.getNextWorker());
                schedule.add(date.toString() + " " + dayOfWeek.toString() + "(휴일) " + weekendOrder.getNextWorker()
                        .toString());
            } else if (dayOfWeek.isWeekday() && !date.isHoliday()) {
                if (sameWorkerPrevious(weekdayOrder.getNextWorker())) {
                    weekdayOrder.updateNextWorker();
                }
                order.add(weekdayOrder.getNextWorker());
                schedule.add(
                        date.toString() + " " + dayOfWeek.toString() + " " + weekdayOrder.getNextWorker().toString());
            } else if (dayOfWeek.isWeekend()) {
                if (sameWorkerPrevious(weekendOrder.getNextWorker())) {
                    weekendOrder.updateNextWorker();
                }
                order.add(weekendOrder.getNextWorker());
                schedule.add(
                        date.toString() + " " + dayOfWeek.toString() + " " + weekendOrder.getNextWorker().toString());
            }
            dayOfWeek.updateNextDay();
        } while (date.updateDay());
        return schedule;
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
