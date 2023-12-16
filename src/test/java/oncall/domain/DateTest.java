package oncall.domain;

import static oncall.consts.Error.INVALID_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DateTest {

    @ParameterizedTest
    @ValueSource(ints = {13, 0})
    @DisplayName("1~12 이외의 값으로 생성하면 예외가 발생한다.")
    void createByWrongRange(int month) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Date(month, 1))
                .withMessage(INVALID_MESSAGE.getMessage());
    }
}