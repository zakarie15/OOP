public class BMI {
    private String name;
    private int age;
    private double weight;
    private double height;

    // Constructor with age
    public BMI(String name, int age, double weight, double height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    // Constructor with default age = 20
    public BMI(String name, double weight, double height) {
        this(name, 20, weight, height);
    }

    // Calculate BMI
    public double getBMI() {
        return weight * 703 / (height * height);
    }

    // Get BMI status
    public String getStatus() {
        double bmi = getBMI();

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}

public class TestBMI {

    public static void main(String[] args) {

        // Create BMI object
        BMI bmi = new BMI("Abdighafar", 21, 150, 65);

        // Display information
        System.out.println("Name: " + bmi.getName());
        System.out.println("Age: " + bmi.getAge());
        System.out.println("Weight: " + bmi.getWeight() + " pounds");
        System.out.println("Height: " + bmi.getHeight() + " inches");

        // Display BMI
        System.out.printf("BMI: %.2f%n", bmi.getBMI());

        // Display status
        System.out.println("Status: " + bmi.getStatus());
    }
}