package oncall.domain;

import static oncall.consts.Error.INVALID_MESSAGE;

import java.util.List;

public class WorkingOrder {

    private static final int MINIMUM_WORKER_SIZE = 5;
    private static final int MAXIMUM_WORKER_SIZE = 35;
    private final List<Worker> workingOrder;

    public WorkingOrder(List<Worker> workingOrder) {
        validate(workingOrder);
        this.workingOrder = workingOrder;
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
        return workingOrder.stream().distinct().toList().size() != workingOrder.size();
    }

    
}
