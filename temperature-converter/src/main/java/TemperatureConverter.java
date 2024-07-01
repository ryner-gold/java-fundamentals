import java.util.Scanner;

// Yey! First exercise!
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tempInCelsius;
        while (true) {
            System.out.println("Enter temperature in Celsius:");
            if (scanner.hasNextDouble()) {
                tempInCelsius = scanner.nextDouble();
                break;  // Valid input, exit the loop
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next();  // Consume the invalid input
            }
        }

        double tempInFahrenheit = (tempInCelsius * 1.8) + 32;

        // Using printf to format the output to 2 decimal places
        System.out.printf("%.2f°C is equal to %.2f°F%n", tempInCelsius, tempInFahrenheit);

        scanner.close();
    }
}