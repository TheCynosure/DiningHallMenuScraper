package main.java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Menu implements Serializable {
    public String menuName;
    public LinkedList<SubMenu> subMenus;

    public Menu(String menuName) {
        this.menuName = menuName;
        this.subMenus = new LinkedList<SubMenu>();
    }
}
