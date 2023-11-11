package christmas.model.order;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OrderTest {
    @DisplayName("주문이 비어있을 경우 예외가 발생한다.")
    @Test
    void createOrderByEmpty() {
        //given
        String order = "";

        //when,then
        assertThatThrownBy(() -> new Order(order)).isInstanceOf(IllegalArgumentException.class);
    }
}