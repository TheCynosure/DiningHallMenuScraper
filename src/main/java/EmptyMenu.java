public class EmptyMenu extends DailyMenu {
    public EmptyMenu() {
        super(LOCATION.FRANKLIN);
    }

    @Override
    void parseFromHtml(String content) {
        //Do nothing.
    }
}
