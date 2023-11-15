package christmas.service;

import christmas.model.reward.Reward;
import christmas.model.reward.Rewards;

import java.util.Map;

public class RewardsService {
    public Rewards createRewards(Map<String, Integer> dDayReward, Map<String, Integer> discountReward, Map<String, Integer> giftReward) {
        Rewards rewards = new Rewards();
        dDayReward.entrySet().forEach(rewardInfo -> addReward(rewards, rewardInfo));
        discountReward.entrySet().forEach(rewardInfo -> addReward(rewards, rewardInfo));
        giftReward.entrySet().forEach(rewardInfo -> addReward(rewards, rewardInfo));
        return rewards;
    }

    private static void addReward(Rewards rewards, Map.Entry<String, Integer> rewardInfo) {
        Reward reward = new Reward(rewardInfo);
        rewards.addReward(reward);
    }
}
