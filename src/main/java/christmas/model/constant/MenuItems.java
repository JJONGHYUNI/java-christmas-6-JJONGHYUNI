package christmas.model.constant;

public enum MenuItems {
    MUSHROOM_SOUP("양송이 수프", 6000, MenuCategory.APPITIZER.getCategoryName()),
    TAPAS("타파스", 5500, MenuCategory.APPITIZER.getCategoryName()),
    CAESAR_SALAD("시저샐러드", 8000, MenuCategory.APPITIZER.getCategoryName()),
    T_BONE_STEAK("티본스테이크", 55000, MenuCategory.MAIN.getCategoryName()),
    BBQ_RIBS("바비큐립", 54000, MenuCategory.MAIN.getCategoryName()),
    SEAFOOD_PASTA("해산물파스타", 35000, MenuCategory.MAIN.getCategoryName()),
    CHRISTMAS_PASTA("크리스마스파스타", 25000, MenuCategory.MAIN.getCategoryName()),
    CHOCOLATE_CAKE("초코케이크", 15000, MenuCategory.DESSERT.getCategoryName()),
    ICE_CREAM("아이스크림", 5000, MenuCategory.DESSERT.getCategoryName()),
    ZERO_COLA("제로콜라", 3000, MenuCategory.DRINK.getCategoryName()),
    RED_WINE("레드와인", 60000, MenuCategory.DRINK.getCategoryName()),
    CHAMPAGNE("샴페인", 25000, MenuCategory.DRINK.getCategoryName());

    private final String menuName;
    private final int price;
    private final String category;

    MenuItems(String menuName, int price, String category) {
        this.menuName = menuName;
        this.price = price;
        this.category = category;
    }
}
