import java.util.Scanner;

public class NumberClassifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double userInput;
        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextDouble()) {
                userInput = scanner.nextDouble();
                break;
            } else {
                System.out.println("Invalid input. Try again.");
                scanner.next();
            }
        }

        if (userInput == 0) {
            System.out.println("User input is 0.");
        } else if (userInput > 0) {
            System.out.println("User input " + userInput + " is positive");
            for (int i = 1; i <= userInput; i++) {
                System.out.println(i + " ");
            }
        } else {
            System.out.println("User input " + userInput + " is negative");
            for (double i = userInput; i <= -1; i++) {
                System.out.println(i + " ");
            }
        }

        scanner.close();
    }
}