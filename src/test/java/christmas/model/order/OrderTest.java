package christmas.model.order;

import christmas.model.event.Event;
import christmas.model.event.WeekDayEvent;
import christmas.model.menu.Menu;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    private final static Event event = new WeekDayEvent();

    @DisplayName("정상적인 주문이 들어왔을 경우 예외가 발생하지 않는다.")
    @Test
    void createMenuSuccess() {
        //given
        String order = "양송이수프-1,제로콜라-3";

        //when,then
        assertThatCode(() -> new Order(order, event)).doesNotThrowAnyException();
    }

    @DisplayName("주문이 비어있을 경우 예외가 발생한다.")
    @Test
    void createOrderByEmpty() {
        //given
        String order = "";

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴를 입력할 경우 예외가 발생한다.")
    @Test
    void createOrderDuplicate() {
        //given
        String order = "양송이수프-1,양송이수프-1";

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 20개 이상이면 예외가 발생한다.")
    @Test
    void createOrderOverBySize() {
        //given
        String order = "양송이수프-21";

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴가 음료로만 구성됐을 경우 예외가 발생한다")
    @Test
    void createOrderOnlyDrinks() {
        //given
        String order = "제로콜라-2";

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }
}