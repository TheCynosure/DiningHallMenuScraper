import java.io.Serializable;
import java.util.LinkedList;

public class SubMenu implements Serializable {
    public String menuName;
    public LinkedList<Food> foods;

    public SubMenu(String menuName) {
        this.menuName = menuName;
        foods = new LinkedList<>();
    }
}
