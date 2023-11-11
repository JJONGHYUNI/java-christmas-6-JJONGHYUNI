package christmas.model.menu.constant;

public enum AppitizerItem {
    MUSHROOM_SOUP("양송이수프", 6000, MenuCategory.APPITIZER.getCategoryName()),
    TAPAS("타파스", 5500, MenuCategory.APPITIZER.getCategoryName()),
    CAESAR_SALAD("시저샐러드", 8000, MenuCategory.APPITIZER.getCategoryName());

    private final String menuName;
    private final int price;
    private final String category;

    AppitizerItem(String menuName, int price, String category) {
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
