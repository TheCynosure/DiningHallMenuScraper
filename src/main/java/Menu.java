import java.util.ArrayList;
import java.util.LinkedList;

public class Menu {
    public String menuName;
    public ArrayList<SubMenu> subMenus;

    public Menu(String menuName) {
        this.menuName = menuName;
        this.subMenus = new ArrayList<>();
    }
}
