import java.util.LinkedList;

public abstract class DailyMenu {

    //Each daily menu can have multiple menus.
    //For example dining halls have ~4 menus, whereas
    //cafes only have 1.
    LinkedList<Menu> menus = new LinkedList<Menu>();

    /**
     *
     * @param content the html content of the menu page.
     *
     * default version does nothing and keeps menu empty.
     */
    abstract void parseFromHtml(String content);

    ;
}
