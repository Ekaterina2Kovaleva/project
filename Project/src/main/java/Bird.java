public class Bird {
    private final int weight; //вес
    private final int height; //рост
    private final int speed; //скорость
    private final String name; //имя
    private final String habitat; //среда обитания
    private final String foodType; //тип питания

    public Bird(int weight, int height, int speed, String name, String habitat, String foodType) {
        this.weight = weight;
        this.height = height;
        this.speed = speed;
        this.name = name;
        this.habitat = habitat;
        this.foodType = foodType;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getFoodType() {
        return foodType;
    }
}
