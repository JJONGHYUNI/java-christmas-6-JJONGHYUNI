package christmas.model.date;

import christmas.model.date.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class DateTest {
    @DisplayName("정상적인 날짜가 들어올 경우 예외가 발생하지 않는다.")
    @Test
    void createDaySuccess() {
        //given
        String day = "5";

        //when,then
        assertThatCode(() -> new Date(day)).doesNotThrowAnyException();
    }

    @DisplayName("날자에 1미만 값이 들어올 경우 예외가 발생한다.")
    @Test
    void createDayUnderBySize() {
        //given
        String day = "0";

        //when,then
        assertThatThrownBy(() -> new Date(day)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("날자에 31초과 값이 들어올 경우 예외가 발생한다.")
    @Test
    void createDayOverBySize() {
        //given
        String day = "32";

        //when,then
        assertThatThrownBy(() -> new Date(day)).isInstanceOf(IllegalArgumentException.class);
    }
}