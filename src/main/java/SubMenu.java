import java.util.LinkedList;

public class SubMenu {
    public String menuName;
    public LinkedList<Food> foods;

    public SubMenu(String menuName) {
        this.menuName = menuName;
        foods = new LinkedList<>();
    }
}
