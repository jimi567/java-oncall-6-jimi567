package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView INSTANCE = new InputView();
    private final OutputView outputView = OutputView.getInstance();

    private InputView() {
    }

    public static InputView getInstance() {
        return INSTANCE;
    }

    public String readDate() {
        outputView.EmergencyWorkDatePrompt();
        return Console.readLine();
    }

    public String readWeekDayOrder() {
        outputView.WeekDayEmergencyNamePrompt();
        return Console.readLine();
    }

    public String readWeekendDayOrder() {
        outputView.WeekendDayEmergencyNamePrompt();
        return Console.readLine();
    }
}
