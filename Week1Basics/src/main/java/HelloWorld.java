import java.util.Scanner;

public class HelloWorld {

  static String greet(String name) {
    return "Hello, " + name + "!";

    }
  public static void main(String[] args) {
    Scanner userInput = new Scanner(System.in);
    String name;

    do {
      System.out.println("Please enter your name:");
      name = userInput.nextLine().trim(); // trim() removes leading/trailing whitespace
      if (!name.isEmpty()) {
        System.out.println(greet(name));
      } else {
        System.out.println("Name cannot be empty!");
      }
    } while (name.isEmpty());

    userInput.close();
  }
}
