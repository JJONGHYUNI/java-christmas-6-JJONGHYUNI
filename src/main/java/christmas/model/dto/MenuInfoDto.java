package christmas.model.dto;

public class MenuInfoDto {
    private final String name;
    private final int count;

    private MenuInfoDto(String name, int count) {
        this.name = name;
        this.count = count;
    }

    public static MenuInfoDto create(String name, int count) {
        return new MenuInfoDto(name, count);
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
