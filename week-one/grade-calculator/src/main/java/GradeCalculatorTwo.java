import java.util.Arrays;
import java.util.Scanner;

public class GradeCalculatorTwo {

  static int calculateAverage(int[] myArray) {
    int sum = 0;
    for (int i = 0; i < myArray.length; i++) {
      sum += myArray[i];
    }

    double average = (double) sum / myArray.length;
    return (int) Math.round(average);
  }

  static int[] calculateHighestAndLowestGrade(int[] myArray) {
    int[] highAndLowArr = new int[2];
    Arrays.sort(myArray);
    int highest = myArray[myArray.length - 1];
    int lowest = myArray[0];
    highAndLowArr[0] = highest;
    highAndLowArr[1] = lowest;
    return highAndLowArr;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int howManyGrades;

    // Ask user how many grades they want to enter
    while (true) {
      System.out.print("How many grades do you want to enter? ");
      if (scanner.hasNextInt()) {
        howManyGrades = scanner.nextInt();
        if (howManyGrades <= 0) {
          System.out.println("Please enter a positive number greater than 0.");
        } else {
          break;
        }
      } else {
        System.out.println("Invalid input. Please enter a whole number.");
        scanner.next(); // Clear the invalid input
      }
    }

    // TODO: Create an array to store the grades
    int[] grades =
        new int
            [howManyGrades]; // Allocate memory specific to how much the user wants for performance

    // TODO: Input grades from user and store in array
    // Grade 1: Highest, Grade 5: Lowest
    // Input grades from user and store in array
    for (int i = 0; i < howManyGrades; i++) {
      while (true) {
        System.out.print("Enter grade #" + (i + 1) + ": ");
        if (scanner.hasNextInt()) {
          int grade = scanner.nextInt();
          if (grade < 0 || grade > 100) { // Assuming grades are between 0 and 100
            System.out.println("Please enter a grade between 0 and 100.");
          } else {
            grades[i] = grade;
            break;
          }
        } else {
          System.out.println("Invalid input. Please enter a whole number.");
          scanner.next(); // Clear the invalid input
        }
      }
    }

    System.out.println("Average of grades: " + calculateAverage(grades));
    int[] highLow = calculateHighestAndLowestGrade(grades);

    System.out.println(
            "Highest of grades: " + highLow[0] + " and lowest of grades: " + highLow[1]);

    scanner.close();
  }

}
