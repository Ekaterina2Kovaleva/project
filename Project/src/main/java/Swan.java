import java.util.ArrayList;
import java.util.List;

public class Swan extends Bird {
    private final int wingspan; //размах крыльев
    private final String headColor; //цвет головы
    private final boolean isWideWinged; //ширококрылый?

    public Swan(int weight, int height, int speed, String name, String habitat, String foodType, int wingspan, String headColor, boolean isWideWinged) {
        super(weight, height, speed, name, habitat, foodType);
        this.wingspan = wingspan;
        this.headColor = headColor;
        this.isWideWinged = isWideWinged;
    }

    public int getWingspan() {
        return wingspan;
    }

    public String getHeadColor() {
        return headColor;
    }

    public boolean isWideWinged() {
        return isWideWinged;
    }

    @Override
    public String toString() {
        return String.format("Swan, %s, %s, %s, %s, %s, %s, %s, %s, %s",
                getWeight(), getHeight(), getSpeed(), getName(),
                getHabitat(), getFoodType(), getWingspan(), getHeadColor(), isWideWinged());
    }

    public static String getLowestButWideWinged(ArrayList<Bird> birds) {
        try {
            List<Swan> swans = birds.stream()
                    .filter(b -> b instanceof Swan)
                    .map(b -> (Swan) b)
                    .toList();
            String answer = "";
            int lowestHeight = 1000;
            for (Swan swan : swans) {
                int currHeight = swan.getHeight();
                if (currHeight < lowestHeight && swan.isWideWinged()) {
                    answer = swan.getName();
                    lowestHeight = currHeight;
                }
            }
            if (answer.equals("")) {
                return "Все лебеди узкокрылые :(";
            } else {
                return String.format("Самый низкий, но ширококрылый лебедь: %s", answer);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
