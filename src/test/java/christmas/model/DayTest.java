package christmas.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DayTest {
    @DisplayName("날자에 1미만 값이 들어올 경우 예외가 발생한다.")
    @Test
    void createDayUnderBySize() {
        //given
        int day = 0;

        //when,then
        assertThatThrownBy(() -> new Day(day)).isInstanceOf(IllegalArgumentException.class);
    }
    
}