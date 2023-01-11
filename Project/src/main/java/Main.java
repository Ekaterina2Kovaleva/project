import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Desktop\\Институт\\Джава\\проект\\Project\\src\\main\\resources\\birds.csv";

        Csv.fill(10, path);

        ArrayList<Bird> birds = Csv.get(path);
        birds.forEach(b -> System.out.println(b.toString()));

        System.out.println(Swan.getLowestButWideWinged(birds));
        System.out.println(Penguin.getThickest(birds));
    }
}
