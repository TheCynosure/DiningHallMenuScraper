import org.junit.Test;

public class TestMenuScraper {
    @Test
    public void testDiningHallMenu() {
        MenuScraper menuScraper = new MenuScraper();
        for(MenuScraper.LOCATION location: MenuScraper.LOCATION.values()) {
            System.out.println("--- --- " + location.name() + " --- ---");
            DailyMenu dailyMenu = menuScraper.getMenu(location);
            for (Menu menu : dailyMenu.menus) {
                System.out.println(menu.menuName);
//
//                for (SubMenu subMenu : menu.subMenus) {
//                    System.out.println("\t" + subMenu.menuName);
//
//                    for (Food food : subMenu.foods) {
//                        System.out.println("\t\t" + food.name + " " + food.calories);
//                    }
//                }
            }
        }
    }
}
