package oncall.domain;

import static oncall.consts.Error.INVALID_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;

public class WorkingOrder {

    private static final int MINIMUM_WORKER_SIZE = 5;
    private static final int MAXIMUM_WORKER_SIZE = 35;
    private final List<Worker> workingOrder;

    private int current;

    public WorkingOrder(List<Worker> workingOrder) {
        validate(workingOrder);
        this.workingOrder = workingOrder;
        current = 0;
    }

    private void validate(List<Worker> workingOrder) {
        if (!validateSize(workingOrder)) {
            INVALID_MESSAGE.throwException();
        } else if (hasDuplication(workingOrder)) {
            INVALID_MESSAGE.throwException();
        }
    }

    private boolean validateSize(List<Worker> workingOrder) {
        return workingOrder.size() >= MINIMUM_WORKER_SIZE && workingOrder.size() <= MAXIMUM_WORKER_SIZE;
    }

    private boolean hasDuplication(List<Worker> workingOrder) {
        return workingOrder.stream().collect(Collectors.toSet()).size() != workingOrder.size();
    }

    public Worker getNextWorker() {
        return workingOrder.get(current);
    }

    public void updateNextWorker() {
        current++;
        if (current == workingOrder.size()) {
            current = 0;
        }
    }

}
