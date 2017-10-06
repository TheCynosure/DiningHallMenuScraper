import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MenuScraper {

    private static String menuBase = "http://umassdining.com/locations-menus/";

    public enum LOCATION {
        FRANKLIN,
        WORCESTER,
        BERKSHIRE,
        HAMPSHIRE
    }

    private String getPageSource(String url) {
        StringBuilder content = new StringBuilder();
        try {
            URL webURL = new URL(url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(webURL.openStream()));
            String line;
            while((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(content);
    }

    public DailyMenu getMenu(LOCATION location) {
        DailyMenu menu = new EmptyMenu();
        if(location == LOCATION.FRANKLIN || location == LOCATION.WORCESTER || location == LOCATION.BERKSHIRE || location == LOCATION.HAMPSHIRE) {
            //This is a dining common.
            menu = new DiningHallDailyMenu();
        }
        menu.parseFromHtml(getPageSource(menuBase + location.name() + "/menu"));
        return menu;
    }
}
