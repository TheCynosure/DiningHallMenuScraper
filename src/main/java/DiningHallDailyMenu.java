import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;

public class DiningHallDailyMenu extends DailyMenu {
    //Dining Halls have 4 menus.
    //Breakfast
    //Lunch
    //Dinner
    //Grab n'Go
    private static String menuNames[] = new String[] {"breakfast_fp", "lunch_fp", "dinner_fp", "grabngo", "latenight_fp"};
    private static String realMenuNames[] = new String[] {"Breakfast", "Lunch", "Dinner", "Grab n'Go", "Late Night"};

    public DiningHallDailyMenu(LOCATION menuLocation) {
        super(menuLocation);
    }

    @Override
    public void parseFromHtml(String content) {
        Document document = Jsoup.parse(content);
        for(int i = 0; i < menuNames.length; i++) {
            //Get each of the menu content collections.
            Element mealMenu = document.getElementsByClass(menuNames[i]).first();
            //Some Dining Halls don't have all the meals, so skip meals that we couldn't find.
            if(mealMenu == null)
                continue;
            //Create a menu for this  meal
            menus.add(new Menu(realMenuNames[i]));
            //Now we want to get the specific subMenus.
            for(Element child: mealMenu.children()) {
                //If it is an h2 then it is a title.
                if(child.tagName().equals("h2")) {
                    //Create a new subMenu and use its text as the name.
                    menus.getLast().subMenus.add(new SubMenu(child.text()));
                }
                //If it is not an h2 then it is a food and we should add
                //it to the last subMenu that was found.
                else if(child.tagName().equals("li")) {
                    Element foodLink = child.children().first();
                    //Get the current menu and submenu,
                    //then add this food to it.
                    menus.getLast().subMenus
                            .get(menus.getLast().subMenus.size() - 1)
                            .foods.add(
                                    new Food(
                                            foodLink.attr("data-dish-name"),
                                            Integer.parseInt(foodLink.attr("data-calories")),
                                            0 //Dining Hall food is free, cost = 0.
                                    )
                            );
                }
            }
        }


    }
}
