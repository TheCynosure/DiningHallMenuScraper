import org.junit.Test;

public class TestMenuScraper {
    @Test
    public void testDiningHallMenu() {
        MenuScraper menuScraper = new MenuScraper();
        for(DailyMenu.LOCATION location: DailyMenu.LOCATION.values()) {
            System.out.println("--- --- " + location.name() + " --- ---");
            DailyMenu dailyMenu = new DiningHallDailyMenu(DailyMenu.LOCATION.FRANKLIN);
            menuScraper.initMenuFromWeb(dailyMenu);
            for (Menu menu : dailyMenu.menus) {
                System.out.println(menu.menuName);

                for (SubMenu subMenu : menu.subMenus) {
                    System.out.println("\t" + subMenu.menuName);

                    for (Food food : subMenu.foods) {
                        System.out.println("\t\t" + food.name + " " + food.calories);
                    }
                }
            }
        }
    }

    @Test
    public void testSaving() {
        MenuScraper menuScraper = new MenuScraper();
        DailyMenu franklinMenu = new DiningHallDailyMenu(DailyMenu.LOCATION.FRANKLIN);
        menuScraper.initMenuFromWeb(franklinMenu);

        franklinMenu.saveMenus("");

        franklinMenu.loadMenus("");
        System.out.println(franklinMenu.menus.getFirst().subMenus.getFirst().foods.getFirst().name);
    }
}
