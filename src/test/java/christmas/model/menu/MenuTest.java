package christmas.model.menu;

import christmas.model.menu.constant.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuTest {
    @DisplayName("메뉴와 메뉴 개수가 한 쌍이 아닐 경우 예외가 발생한다.")
    @Test
    void createMenuIsNotPare() {
        //given
        String order = "양송이수프-1-2";

        //when,then
        assertThatThrownBy(() -> new Menu(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하지 않는 메뉴가 들어올 시 예외가 발생한다.")
    @Test
    void createMenuIsNotContainMenuName() {
        //given
        String order = "종현-1";

        //when,then
        assertThatThrownBy(() -> new Menu(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 개수가 숫자가 아닐 경우 예외가 발생한다.")
    @Test
    void createMenuCountIsNotNumeric() {
        //given
        String order = "양송이수프-q";

        //when,then
        assertThatThrownBy(() -> new Menu(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 개수가 1보다 작을 경우 예외가 발생한다")
    @Test
    void createMenuCountUnderBySize() {
        //given
        String order = "양송이수프-0";

        //when,then
        assertThatThrownBy(() -> new Menu(order)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴 한 쌍이 정상적으로 입력됐을 때 정상적으로 만들어지는 지 확인한다.")
    @Test
    void createMenuSuccess() {
        //given
        String order = "양송이수프-1";

        //when
        Menu menu = new Menu(order);

        //then
        assertThat(menu.getMenuItem().getMenuName().equals(MenuItem.MUSHROOM_SOUP.getMenuName()))
                .isEqualTo(true);
        assertThat(menu.getCount() == 1).isEqualTo(true);
    }
}