import java.io.Serializable;

public class Food implements Serializable {
    String name;
    int cost;
    int calories;

    public Food(String name, int calories, int cost) {
        this.name = name;
        this.calories = calories;
        this.cost = cost;
    }
}
