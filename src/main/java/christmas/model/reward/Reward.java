package christmas.model.reward;

import java.util.HashMap;
import java.util.Map;

public class Reward {
    private final Map<String, Integer> rewards = new HashMap<>();

    public void addReward(Map<String, Integer> reward) {
        rewards.putAll(reward);
    }

    public int getBenefit() {
        return rewards.values().stream().mapToInt(Integer::intValue).sum();
    }
}
