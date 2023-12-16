package oncall.domain;

import static oncall.consts.Error.INVALID_MESSAGE;

public class Worker {

    private static final int MAXIMUM_NAME_SIZE = 5;
    private static final int MINIMUM_NAME_SIZE = 1;
    private final String name;

    public Worker(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (!validateSize(name)) {
            INVALID_MESSAGE.throwException();
        }
    }

    private boolean validateSize(String name) {
        return name.length() <= MAXIMUM_NAME_SIZE && name.length() >= MINIMUM_NAME_SIZE;
    }

    @Override
    public boolean equals(Object name) {
        return this.name.equals(name);
    }

    @Override
    public String toString() {
        return name;
    }

}
