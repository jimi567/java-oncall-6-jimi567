package oncall.controller;

import java.util.List;
import java.util.Map;
import oncall.domain.Date;
import oncall.domain.DayOfWeek;
import oncall.domain.Worker;
import oncall.domain.WorkingOrder;
import oncall.service.OnCallService;
import oncall.utils.InputParser;
import oncall.view.InputView;
import oncall.view.OutputView;

public class OnCallController {

    private final InputParser inputParser = new InputParser();
    private final OutputView outputView = OutputView.getInstance();
    private final InputView inputView = InputView.getInstance();

    private Date date;
    private DayOfWeek dayOfWeek;
    private WorkingOrder weekdayOrder;
    private WorkingOrder weekendOrder;

    private OnCallService onCallService;

    public void run() {
        setDateAndDayOfWeek();
        setWeekdayOrder();
        setWeekendOrder();
        setOnCallService();
        showResult();
    }

    private void setDateAndDayOfWeek() {
        try {
            Map<Integer, String> parsedData = inputParser.parseMonthAndDayOfWeek(inputView.readDate());
            date = new Date(parsedData.keySet().stream().findFirst().get(), 1);
            dayOfWeek = new DayOfWeek(parsedData.values().stream().findFirst().get());
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setDateAndDayOfWeek();
        }
    }

    private void setWeekdayOrder() {
        try {
            List<Worker> parsedData = inputParser.parseWorkingOrder(inputView.readWeekDayOrder());
            weekdayOrder = new WorkingOrder(parsedData);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setWeekdayOrder();
        }
    }

    private void setWeekendOrder() {
        try {
            List<Worker> parsedData = inputParser.parseWorkingOrder(inputView.readWeekendDayOrder());
            weekendOrder = new WorkingOrder(parsedData);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            setWeekendOrder();
        }
    }

    private void setOnCallService() {
        onCallService = new OnCallService(date, dayOfWeek, weekdayOrder, weekendOrder);
    }

    private void showResult() {
        outputView.printResult(onCallService.getSchedule());
    }
}
