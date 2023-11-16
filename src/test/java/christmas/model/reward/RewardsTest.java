package christmas.model.reward;

import christmas.model.dto.RewardInfoDto;
import christmas.model.event.constant.EventConstants;
import christmas.service.RewardsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RewardsTest {
    private static final RewardsService rewardsService = new RewardsService();
    private Rewards rewards;

    //평일 할인(dessert 한개 기준), 크리스마스할인 1일 기준, 증정 이벤트 적용 기준
    @BeforeEach
    void init() {
        List<RewardInfoDto> discountDtos = new ArrayList<>();
        discountDtos.add(RewardInfoDto.create(EventConstants.WEEKDAY_EVENT_SALE_PRICE.getTitle(), EventConstants.WEEKDAY_EVENT_SALE_PRICE.getPrice()));
        List<RewardInfoDto> dDayDtos = new ArrayList<>();
        dDayDtos.add(RewardInfoDto.create(EventConstants.CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE.getTitle(), EventConstants.CHRISTMAS_D_DAY_DEFAULT_SALE_PRICE.getPrice()));
        List<RewardInfoDto> giftDtos = new ArrayList<>();
        giftDtos.add(RewardInfoDto.create(EventConstants.GIFT_EVENT_PRICE.getTitle(), EventConstants.GIFT_EVENT_PRICE.getPrice()));
        rewards = rewardsService.createRewards(dDayDtos, discountDtos, giftDtos, false);
    }

    @DisplayName("혜택 금액을 구한 값이 올바를 경우 true를 반환한다.")
    @Test
    void checkCalcurateBenefit() {
        //given
        int benefit = rewards.calculateBenfit();

        //when,then
        assertThat(benefit == - (1000 + 2023 + 25000)).isEqualTo(true);
    }

    @DisplayName("증정 이벤트를 제외하고 결제 금액에서 빠지는 금액이 올바를 경우 true를 반환한다.")
    @Test
    void checkCalcurateDiscountPrice() {
        //given
        int discountPrice = rewards.calculateDiscountPrice();

        //when,then
        assertThat(discountPrice == - (1000 + 2023)).isEqualTo(true);
    }

    @DisplayName("혜택 금액에 따른 올바른 배지를 찾을 경우 true를 반환한다.")
    @Test
    void checkFindBadge() {
        //given
        String badge = rewards.findBadgeForBenefit();

        //when,then
        assertThat(badge.equals(EventConstants.SANTA_BADGE_INFORMATION.getTitle())).isEqualTo(true);
    }
}