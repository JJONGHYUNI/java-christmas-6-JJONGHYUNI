package christmas.model.reward;

public class Reward {
    private final String title;
    private final int benefit;

    public Reward(String title, int benefit) {
        this.title = title;
        this.benefit = benefit;
    }

    public String getTitle() {
        return title;
    }

    public int getBenefit() {
        return benefit;
    }
}
