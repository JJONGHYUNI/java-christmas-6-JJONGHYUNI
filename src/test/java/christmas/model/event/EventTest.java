package christmas.model.event;

import christmas.model.menu.constant.MenuCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {
    private static final Event event = new WeekDayEvent();

    @DisplayName("이벤트 적용 기준 값에 주문 전 총 금액이 미치지 못할 경우 true를 반환한다.")
    @Test
    void checkAppliedEvent() {
        //given
        int totalPrice = 9999;

        //when,then
        assertThat(event.isAppliedEvent(totalPrice)).isEqualTo(true);
    }

    @DisplayName("주문한 메뉴에 메인메뉴가 있을 경우 true를 반환한다.")
    @Test
    void checkOrderContainMainMenu() {
        //given
        Map<String, Integer> categorys = Map.of(MenuCategory.MAIN.getCategoryName(), 2);

        //when,then
        assertThat(event.isContainMainCategory(categorys)).isEqualTo(true);
    }

    @DisplayName("주문한 메뉴에 디저트가 있을 경우 true를 반환한다.")
    @Test
    void checkOrderContainDessertMenu() {
        //given
        Map<String, Integer> categorys = Map.of(MenuCategory.DESSERT.getCategoryName(), 2);

        //when,then
        assertThat(event.isContainDessertCategory(categorys)).isEqualTo(true);
    }
}