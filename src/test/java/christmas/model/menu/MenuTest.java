package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {
    @DisplayName("메뉴 목록에 없는 메뉴가 들어올 경우 예외가 발생한다.")
    @Test
    void createMenuByNothingMenuItem() {
        //given
        String order = "종현-1";

        //when,then
        assertThatThrownBy(() -> new Appitizer(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 작성 값이 size를 초과할 경우 예외 발생")
    @Test
    void createMenuByOverSize() {
        //given
        String order = "양송이수프-2-2";

        //when,then
        assertThatThrownBy(() -> new Appitizer(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 작성 값이 size 미만일 경우 예외 발생")
    @Test
    void createMenuByUnderSize() {
        //given
        String order = "양송이수프";

        //when,then
        assertThatThrownBy(() -> new Appitizer(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 작성을 올바르게 했을 경우 통과한다.")
    @Test
    void createMenu() {
        //given
        String order = "양송이수프-1";

        //when
        Menu menu = new Appitizer(order);

        //then
        assertThat(menu.getMenuItem() == MenuItem.MUSHROOM_SOUP).isEqualTo(true);
        assertThat(menu.getCount() == 1).isEqualTo(true);
    }
}