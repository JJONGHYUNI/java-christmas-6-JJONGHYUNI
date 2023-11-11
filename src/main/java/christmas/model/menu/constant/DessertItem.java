package christmas.model.menu.constant;

public enum DessertItem {
    CHOCOLATE_CAKE("초코케이크", 15000, MenuCategory.DESSERT.getCategoryName()),
    ICE_CREAM("아이스크림", 5000, MenuCategory.DESSERT.getCategoryName());

    private final String menuName;
    private final int price;
    private final String category;

    DessertItem(String menuName, int price, String category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }

//    public static MenuItem findOrderMenu(String orderName) {
//        for(MenuItem menuItem : MenuItem.values()) {
//            if (menuItem.getMenuName().equals(orderName)) return menuItem;
//        }
//        throw new IllegalArgumentException();
//    }

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
