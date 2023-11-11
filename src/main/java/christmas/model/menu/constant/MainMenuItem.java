package christmas.model.menu.constant;

public enum MainMenuItem {
    T_BONE_STEAK("티본스테이크", 55000, MenuCategory.MAIN.getCategoryName()),
    BBQ_RIBS("바비큐립", 54000, MenuCategory.MAIN.getCategoryName()),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuCategory.MAIN.getCategoryName()),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuCategory.MAIN.getCategoryName());

    private final String menuName;
    private final int price;
    private final String category;

    MainMenuItem(String menuName, int price, String category) {
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
