package main.java;

import main.java.DailyMenu;

public class EmptyMenu extends DailyMenu {
    public EmptyMenu() {
        super(LOCATION.FRANKLIN);
    }

    void parseFromHtml(String content) {
        //Do nothing.
    }
}
