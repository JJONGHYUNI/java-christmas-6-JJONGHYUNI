package christmas.model.reward;

import java.util.HashMap;
import java.util.Map;

public class Reward {
    private final String title;
    private final int benefit;

    public Reward(Map.Entry<String, Integer> reward) {
        this.title = reward.getKey();
        this.benefit = reward.getValue();
    }

    public String getTitle() {
        return title;
    }

    public int getBenefit() {
        return benefit;
    }
}
