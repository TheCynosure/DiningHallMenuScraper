import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class MenuScraper {

    private static String menuBase = "http://umassdining.com/locations-menus/";

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

    public void initMenuFromWeb(DailyMenu menu) {
        menu.parseFromHtml(getPageSource(menuBase + menu.getLocation().name().toLowerCase() + "/menu"));
    }
}
