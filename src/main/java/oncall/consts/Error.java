package oncall.consts;

public enum Error {

    INVALID_MESSAGE("유효하지 않은 입력 값입니다. 다시 입력해 주세요.");

    private final String ERROR = "[ERROR] ";
    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR + message;
    }

    public void throwException() {
        throw new IllegalArgumentException(getMessage());
    }
}
