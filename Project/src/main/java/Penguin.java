import java.util.ArrayList;
import java.util.List;

public class Penguin extends Bird {
    private final int lifespan; //продолжительность жизни
    private final String type; //тип
    private final boolean isRollingOnStomach; //катается на животе?

    public Penguin(int weight, int height, int speed, String name, String habitat, String foodType, int lifespan, String type, boolean isRollingOnStomach) {
        super(weight, height, speed, name, habitat, foodType);
        this.lifespan = lifespan;
        this.type = type;
        this.isRollingOnStomach = isRollingOnStomach;
    }

    public int getLifespan() {
        return lifespan;
    }

    public String getType() {
        return type;
    }

    public boolean isRollingOnStomach() {
        return isRollingOnStomach;
    }

    @Override
    public String toString() {
        return String.format("Penguin, %s, %s, %s, %s, %s, %s, %s, %s, %s",
                getWeight(), getHeight(), getSpeed(), getName(),
                getHabitat(), getFoodType(), getLifespan(), getType(), isRollingOnStomach());
    }

    public static String getThickest(ArrayList<Bird> birds) {
        try {
            List<Penguin> penguins = birds.stream()
                    .filter(b -> b instanceof Penguin)
                    .map(b -> (Penguin) b)
                    .toList();
            String answer = "";
            int highestWeight = 0;
            for (Penguin penguin : penguins) {
                int currWeight = penguin.getWeight();
                if (currWeight > highestWeight) {
                    answer = penguin.getName();
                    highestWeight = currWeight;
                }
            }
            return String.format("Самый тяжелый пингвин: %s", answer);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
