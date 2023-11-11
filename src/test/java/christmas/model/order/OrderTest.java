package christmas.model.order;

import christmas.model.event.Event;
import christmas.model.event.WeekDayEvent;
import christmas.model.reward.Reward;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @DisplayName("주문이 비어있을 경우 예외가 발생한다.")
    @Test
    void createOrderByEmpty() {
        //given
        String order = "";
        Event event = new WeekDayEvent();

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 메뉴를 입력할 경우 예외가 발생한다.")
    @Test
    void createOrderDuplicate() {
        //given
        String order = "양송이수프-1,양송이수프-1";
        Event event = new WeekDayEvent();

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴의 개수가 20개 이상이면 예외가 발생한다.")
    @Test
    void createOrderOverBySize() {
        //given
        String order = "양송이수프-21";
        Event event = new WeekDayEvent();

        //when,then
        assertThatThrownBy(() -> new Order(order, event)).isInstanceOf(IllegalArgumentException.class);
    }
}