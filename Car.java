import java.util.Random;

public class Car {
        // establishing class variables
    private String make;
    private String model;
    private int year;
    private String color;
    private int fueltank;
    private String fueltype;
    private double economy;
    private double range;
    private String vin;
    private int topspeed;
    private double mileage;
    private Random rand;

        // Lists for generating a new car
    String makes[] = {"Toyota", "Honda", "Kia", "Audi", "Ford", "Dodge", "Mazda", "Subaru", "BMW"};
    String models[] = {"Corolla", "Civic", "Spectra", "R8", "F150", "Challenger", "Miata", "Outback", "M3"};
    String fuelTypes[] = {"Regular", "Regular", "Regular", "Premium", "Diesel", "Regular", "Regular", "Regular", "Premium"};
    String colors[] = {"Red", "Blue", "Green", "White", "Black", "Gray", "Yellow", "Purple", "Pink", "Orange"};
    String vinList = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


        // default constructor
    public Car() {
        rand = new Random();
        int num = rand.nextInt(makes.length);
        this.make = makes[num];
        this.model = models[num];
        this.fueltype = fuelTypes[num];
        this.year = rand.nextInt(1999,2024);
        this.color = colors[rand.nextInt(colors.length)];
        this.vin = vinGen();
        this.topspeed = rand.nextInt(90, 200);
        this.fueltank = rand.nextInt(12, 20);
        this.economy = rand.nextDouble(18.0, 30.0);
        this.range = this.fueltank * this.economy;
        this.mileage = rand.nextDouble(0.0, 300000.0);
    }


        // Overloaded constructor
    public Car(String make, String model, int year, String color, String vin, int topspeed, String fueltype) {
        rand = new Random();
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
        this.topspeed = topspeed;
        this.fueltype = fueltype;
        this.fueltank = rand.nextInt(12, 20);
        this.economy = rand.nextDouble(18.0, 28.0);
        this.range = this.fueltank * this.economy;
        this.mileage = 0.0F;

    }


        // existing constructor
    public Car(String make, String model, int year, String color, String vin, int topspeed, double economy, String fueltype, double mileage, int fueltank) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.vin = vin;
        this.topspeed = topspeed;
        this.economy = economy;
        this.fueltank = fueltank;
        this.range = this.economy * this.fueltank;
        this.fueltype = fueltype;
        this.mileage = mileage;

    }


        // Method to generate the vin number
    public String vinGen() {
        String vinTemp = "";
        for (int i=0; i<17; i++) {
            char letter = vinList.charAt(rand.nextInt(35));
            vinTemp += letter;
        }
        return vinTemp;
    }


        // Method for returning basic info about the car
    public String toString() {
        return this.year + " " + this.make + " " + this.model;
    }

        // Method for returning all the info about the car
    public String carfax() {
        return this.color + " " + this.year + " " + this.make + " " + this.model + System.lineSeparator() + this.mileage + " Miles" + System.lineSeparator() + "VIN: " + this.vin + System.lineSeparator() + "Top Speed: " + this.topspeed + System.lineSeparator() + this.economy + " MPG (" + this.fueltype + "), " + this.fueltank + " Gallon Capacity, " + this.range + " Range";
    }

}
