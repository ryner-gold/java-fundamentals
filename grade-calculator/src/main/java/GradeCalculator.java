import java.util.Scanner;
import java.util.Arrays;

public class GradeCalculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int howManyGrades;
    int givenGrade;
    int sumOfGrades = 0;
    // TODO: Ask user how many grades they want to enter
    while (true) {
      System.out.print("How many grades do you want to enter? ");
      if (scanner.hasNextInt()) {
        howManyGrades = scanner.nextInt();
        break;
      } else {
        System.out.println("Invalid input. Please enter a whole number: ");
        scanner.next();
      }
    }
    // TODO: Create an array to store the grades
    int[] myArray = new int[howManyGrades]; // Allocate memory specific to how much the user wants for performance

    // TODO: Input grades from user and store in array
    // Grade 1: Highest, Grade 5: Lowest
    for (int i = 0; i < howManyGrades; i++) {
      System.out.print("Enter your grade: ");

      // Only accept int numbers for givenGrade
      while(true){
        if(scanner.hasNextInt()){
          givenGrade = scanner.nextInt();
          System.out.println("Your inputted grade: " + givenGrade);
          myArray[i] = givenGrade; // Append given grade
          break;
        } else {
          System.out.println("Invalid input. Please enter a whole number. ");
          scanner.next();
        }
      }
    }

    // Print array
      for (int i = 0; i < myArray.length; i++) {
          sumOfGrades += myArray[i];
          System.out.print(myArray[i] + ", ");
      }

    // TODO: Calculate average grade
    System.out.print("Sum of grades: " + sumOfGrades);
      int averageGrade = sumOfGrades / howManyGrades;
    System.out.println("Average of grades: " + averageGrade);
    // TODO: Find highest and lowest grades
     Arrays.sort(myArray);
    System.out.println("Highest grade: " + myArray[myArray.length - 1]);
    System.out.println("Lowest grade: " + myArray[0]);
    // TODO: Print all grades, average, highest, and lowest
    System.out.println("All grades" + Arrays.toString(myArray));
    System.out.println("Average: " + averageGrade + "\n" + "Highest: " + myArray[myArray.length - 1] + "\n" + "Lowest: " + myArray[0]);
    scanner.close();
  }

  // TODO: Create a method to calculate average

  static int calculateAverage(int[] myArray) {
    int sum = 0;
    for (int i = 0; i < myArray.length; i++) {
      sum += myArray[i];
      System.out.println("Sum of grades: " + sum);
    }

    int average = sum / myArray.length;
    return average;
  }
  // TODO: Create a method to find highest grade
  // TODO: Create a method to find lowest grade
  // Using Arrays.sort() I can do both

  static int[] calculateHighestAndLowestGrade(int[] myArray) {
    int[] highAndLowArr = new int[2];
    Arrays.sort(myArray);
    int highest = myArray[myArray.length - 1];
    int lowest = myArray[0];
    highAndLowArr[0] = highest;
    highAndLowArr[1] = lowest;
    return highAndLowArr;
  }
}
