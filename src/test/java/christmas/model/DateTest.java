package christmas.model;

import christmas.model.date.Date;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DateTest {
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