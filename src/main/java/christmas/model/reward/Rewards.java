package christmas.model.reward;

import christmas.model.event.constant.EventConstants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards() {
        this.rewards = new ArrayList<>();
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }

    public List<Reward> getRewards() {
        return Collections.unmodifiableList(rewards);
    }

    public int getBenfit() {
        return rewards.stream().mapToInt(Reward::getBenefit).sum();
    }

    public int calculateDiscountPrice() {
        List<String> rewardTitles = rewards.stream().map(Reward::getTitle).toList();
        if (rewardTitles.contains(EventConstants.GIFT_EVENT_PRICE.getSaleTitle())) {
            return getBenfit() - EventConstants.GIFT_EVENT_PRICE.getSalePrice();
        }
        return getBenfit();
    }
}
