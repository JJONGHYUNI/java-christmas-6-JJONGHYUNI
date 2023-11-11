package christmas.model.menu;

abstract class Menu {
    private final String menuName;
    private final int price;
    private final int count;

    public Menu(String menuName, int price, String count) {
        int validCount = validateCount(count);
        validateCountRange(validCount);
        this.menuName = menuName;
        this.price = price;
        this.count = validCount;
    }

    private int validateCount(String count) {
        try {
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCountRange(int count) {
        if(count < 1) {
            throw new IllegalArgumentException();
        }
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
