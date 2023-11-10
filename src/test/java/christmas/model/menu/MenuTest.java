package christmas.model.menu;

import christmas.model.day.Day;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {
    @DisplayName("메뉴 목록에 없는 메뉴가 들어올 경우 예외가 발생한다.")
    @Test
    void createMenuByNothingMenuItem() {
        //given
        String menuName = "종현";

        //when,then
        assertThatThrownBy(() -> new Appitizer(menuName, 1)).isInstanceOf(IllegalArgumentException.class);
    }
}