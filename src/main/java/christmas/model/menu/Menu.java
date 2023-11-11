package christmas.model.menu;

abstract class Menu {
    private final String menuName;
    private final int price;
    private final int count;

    public Menu(String menuName, int price, int count) {
        this.menuName = menuName;
        this.price = price;
        this.count = count;
    }

    public int getCount() {
        return count;
    }
}
