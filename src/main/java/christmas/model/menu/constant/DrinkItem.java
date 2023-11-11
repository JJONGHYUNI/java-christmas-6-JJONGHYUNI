package christmas.model.menu.constant;

public enum DrinkItem {
    ZERO_COLA("제로콜라", 3000, MenuCategory.DRINK.getCategoryName()),
    RED_WINE("레드와인", 60000, MenuCategory.DRINK.getCategoryName()),
    CHAMPAGNE("샴페인", 25000, MenuCategory.DRINK.getCategoryName());

    private final String menuName;
    private final int price;
    private final String category;

    DrinkItem(String menuName, int price, String category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

    public String getMenuName() {
        return menuName;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
