import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generator {
    public static ArrayList<Bird> generateBirds(int count) {
        List<String> birdNames = Arrays.asList("Harry", "Oliver", "Jack", "Charlie", "Thomas", "Jacob", "Alfie",
                "Riley", "William", "James", "Jessica", "Emily", "Amelia", "Olivia", "Lily ", "Ava", "Heather",
                "Sophie", "Mia", "Isabella", "Matthew");

        List<String> swanHabitats = Arrays.asList("Australia", "South America", "North America", "Kola Peninsula",
                "Chukotka", "Chile", "Patagonia", "Brazil");

        List<String> penguinHabitats = Arrays.asList("Antarctica", "New Zealand", "Australia", "South Africa",
                "South America", "Falkland Islands", "Peru", "Galapagos Islands", "Cape of Good Hope");

        List<String> birdFoodType = Arrays.asList("carnivores", "herbivores");

        List<String> swanHeadColor = Arrays.asList("Black", "Grey", "White", "Red", "Yellow");

        List<String> penguinType = Arrays.asList("Imperial", "Crested", "Fatcloth", "Goldilocks",
                "Magnificent", "Antarctic", "Magellanic", "Score");

        ArrayList<Bird> birds = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (rnd(0, 1) == 1) {
                birds.add(new Swan(rnd(7, 25), rnd(100, 180), rnd(60, 80), birdNames.get(rnd(0, birdNames.size() - 1)),
                        swanHabitats.get(rnd(0, swanHabitats.size() - 1)),
                        birdFoodType.get(rnd(0, birdFoodType.size() - 1)), rnd(1, 4),
                        swanHeadColor.get(rnd(0, swanHeadColor.size() - 1)), rnd(0, 1) != 0));
            } else {
                birds.add(new Penguin(rnd(1, 46), rnd(30, 140), rnd(15, 36), birdNames.get(rnd(0, birdNames.size() - 1)),
                        penguinHabitats.get(rnd(0, penguinHabitats.size() - 1)),
                        birdFoodType.get(rnd(0, birdFoodType.size() - 1)), rnd(6, 25),
                        penguinType.get(rnd(0, penguinType.size() - 1)), rnd(0, 1) != 0));
            }
        }
        return birds;
    }

    private static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
