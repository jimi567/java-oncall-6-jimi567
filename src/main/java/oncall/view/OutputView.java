package oncall.view;

import java.util.List;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return INSTANCE;
    }

    public void EmergencyWorkDatePrompt() {
        System.out.print("비상 근무를 배정할 월과 시작 요일을 입력하세요> ");
    }

    public void WeekDayEmergencyNamePrompt() {
        System.out.print("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void WeekendDayEmergencyNamePrompt() {
        System.out.print("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");
    }

    public void printResult(List<String> schedule) {
        System.out.println();
        System.out.println(String.join(System.lineSeparator(), schedule));
    }

    public void printErrorMessage(String message) {
        System.out.println();
        System.out.println(message);
    }
}
