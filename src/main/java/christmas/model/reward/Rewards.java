package christmas.model.reward;

import java.util.ArrayList;
import java.util.List;

public class Rewards {
    private final List<Reward> rewards;

    public Rewards() {
        this.rewards = new ArrayList<>();
    }

    public void addReward(Reward reward) {
        rewards.add(reward);
    }
}
