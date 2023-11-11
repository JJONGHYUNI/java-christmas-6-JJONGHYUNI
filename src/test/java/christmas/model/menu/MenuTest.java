package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {
    @DisplayName("메뉴 개수에 숫자 이외의 값이 들어올 경우 예외가 발생한다.")
    @Test
    void createMenuCountIsNotNumeric() {
        //given
        MenuItem menuItem = MenuItem.MUSHROOM_SOUP;
        String count = "s";

        //when,then
        assertThatThrownBy(() -> new Appitizer(menuItem.getMenuName(), menuItem.getPrice(), count))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 개수가 1보다 작은 경우 예외가 발생한다")
    @Test
    void createMenuCountUnderBySize() {
        //given
        MenuItem menuItem = MenuItem.MUSHROOM_SOUP;
        String count = "0";

        //when,then
        assertThatThrownBy(() -> new Appitizer(menuItem.getMenuName(), menuItem.getPrice(), count))
                .isInstanceOf(IllegalArgumentException.class);
    }
}