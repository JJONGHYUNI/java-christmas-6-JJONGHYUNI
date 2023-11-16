package christmas.model.dto;

public class RewardInfoDto {
    private final String rewardTitle;
    private final int rewardPrice;

    private RewardInfoDto(String title, int price) {
        this.rewardTitle = title;
        this.rewardPrice = price;
    }

    public static RewardInfoDto create(String title, int price) {
        return new RewardInfoDto(title, price);
    }

    public String getRewardTitle() {
        return rewardTitle;
    }

    public int getRewardPrice() {
        return rewardPrice;
    }
}
