import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Csv {
    public static void fill(int count, String path) {
        try {
            ArrayList<Bird> birds = Generator.generateBirds(count);
            CSVWriter writer = new CSVWriter(new FileWriter(path));
            String[] headers = ("bird, weight, height, speed, name, habitat, food type, wingspan | lifespan, head color | type, wide winged | rolling on stomach").split(", ");
            writer.writeNext(headers);
            for (var bird :
                    birds) {
                writer.writeNext(bird.toString().split(", "));
            }
            writer.close();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public static ArrayList<Bird> get(String path) {
        try {
            List<String[]> reader = new CSVReader(new FileReader(path)).readAll();
            List<String[]> data = reader.subList(1, reader.size());
            ArrayList<Bird> birds = new ArrayList<>();
            for (String[] b : data) {
                birds.add(Objects.equals(b[0], "Swan") ? new Swan(
                        Integer.parseInt(b[1]), Integer.parseInt(b[2]), Integer.parseInt(b[3]), b[4], b[5], b[6],
                        Integer.parseInt(b[7]), b[8], Boolean.parseBoolean(b[9])
                ) : new Penguin(
                        Integer.parseInt(b[1]), Integer.parseInt(b[2]), Integer.parseInt(b[3]), b[4], b[5], b[6],
                        Integer.parseInt(b[7]), b[8], Boolean.parseBoolean(b[9])
                ));
            }
            return birds;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

}
