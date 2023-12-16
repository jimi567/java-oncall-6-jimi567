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

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Worker otherWorker = (Worker) obj;
        return this.name.equals(otherWorker.getName());
    }

    @Override
    public String toString() {
        return name;
    }

}
