package main.java;

import java.awt.*;
import java.io.*;
import java.util.LinkedList;

public abstract class DailyMenu {

    //Each daily menu can have multiple menus.
    //For example dining halls have ~4 menus, whereas
    //cafes only have 1.
    LinkedList<Menu> menus = new LinkedList<Menu>();

    //All the locations supported in the dailyMenu format
    public enum LOCATION {
        FRANKLIN,
        WORCESTER,
        BERKSHIRE,
        HAMPSHIRE
    }
    //This menu is for a specific location.
    private LOCATION menuLocation;

    public DailyMenu(LOCATION menuLocation) {
        this.menuLocation = menuLocation;
    }

    /**
     *
     * @param content the html content of the menu page.
     *
     */
    abstract void parseFromHtml(String content);

    /**
     *
     * @param filePath the folder in which to save the menu file. The fileName is the menuLocation.ser, should
     *                 have a '/' at the end.
     *
     * default version of this method just saves the menus to a serialized file.
     */
    public void saveMenus(String filePath) {
        File saveFile = new File(filePath + menuLocation.name() + ".ser");
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(saveFile));
            for(Menu m: menus) {
                writer.writeObject(m);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param filePath the folder in which to load the menu file with name menuLocation.ser, should have a '/'
     *                 at the end.
     *
     * default version of this method just loads the menus from a serialized file.
     */
    public void loadMenus(String filePath) {
        menus.clear();
        File saveFile = new File(filePath + menuLocation.name() + ".ser");
        try {
            ObjectInputStream reader = new ObjectInputStream(new FileInputStream(saveFile));
            Menu menu;
            //Really stupid...
            //Java doesn't have a nice way to handle hitting the EOF, instead we
            //just have to catch the exception and carry on from there.
            while(true) {
                try {
                    menu = (Menu) reader.readObject();
                    menus.add(menu);
                } catch (EOFException e) {
                    break;
                }
            }
            reader.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public LOCATION getLocation() {
        return menuLocation;
    }
}
