package christmas.model.reward;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static christmas.model.event.constant.EventConstants.*;

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

    public int calculateBenfit() {
        return rewards.stream().mapToInt(Reward::getBenefit).sum();
    }

    public int calculateDiscountPrice() {
        List<String> rewardTitles = rewards.stream().map(Reward::getTitle).toList();
        if (rewardTitles.contains(GIFT_EVENT_PRICE.getTitle())) {
            return calculateBenfit() - GIFT_EVENT_PRICE.getPrice();
        }
        return calculateBenfit();
    }

    public String findBadgeForBenefit() {
        int benefit = - calculateBenfit();
        if (benefit >= SANTA_BADGE_INFORMATION.getPrice()) {
            return SANTA_BADGE_INFORMATION.getTitle();
        }
        if (benefit >= TREE_BADGE_INFORMATION.getPrice()) {
            return TREE_BADGE_INFORMATION.getTitle();
        }
        if (benefit >= STAR_BADGE_INFORMATION.getPrice()) {
            return STAR_BADGE_INFORMATION.getTitle();
        }
        return NOTHING_BADGE_INFORMATION.getTitle();
    }
}
