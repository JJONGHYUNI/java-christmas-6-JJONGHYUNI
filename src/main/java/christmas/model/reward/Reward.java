package christmas.model.reward;

import christmas.model.event.Event;

import java.util.HashMap;
import java.util.Map;

public class Reward {
    private final int totalPriceBeforeDiscount;
    private final Map<String, Integer> rewards;
    private final Event event;

    public Reward(int totalPriceBeforeDiscount, Event event) {
        this.totalPriceBeforeDiscount = totalPriceBeforeDiscount;
        rewards = new HashMap<>();
        this.event = event;
    }

    public void addReward(Map<String, Integer> reward) {
        rewards.putAll(reward);
    }

    public int getBenefit() {
        return rewards.values().stream().mapToInt(Integer::intValue).sum();
    }
}
