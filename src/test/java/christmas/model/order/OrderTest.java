package christmas.model.order;

import christmas.model.menu.Appitizer;
import christmas.model.menu.constant.MenuItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @DisplayName("주문 입력 내용에서 주문 메뉴와 주문 개수가 한 쌍이 아닐 시 예외가 발생한다.")
    @Test
    void createOrderMenuAndCountIsNotMatching() {
        //given
        String orderInput = "양송이수프-1-2";

        //when,then
        assertThatThrownBy(() -> new Order(orderInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("주문 입력 메뉴가 존재하지 않는 메뉴일 시 예외가 발생한다")
    @Test
    void createOrderNotContainMenuItem() {
        //given
        String orderInput = "종현이-1";

        //when,then
        assertThatThrownBy(() -> new Order(orderInput))
                .isInstanceOf(IllegalArgumentException.class);
    }
}