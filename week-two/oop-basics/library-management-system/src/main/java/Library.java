import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Library {
  private final String name;
  private final ArrayList<Book> books;

  public Library(String name) {
    this.name = name;

    this.books =
        new ArrayList<>(
            Arrays.asList(
                new Book("1984", "George Orwell", "9780451524935"),
                new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")));
  }

  public String getName() {
    return name;
  }

  public ArrayList<Book> getBooks() {
    return books;
  }

  public Library addBookToLibrary(Book book, Library library) {
    library.books.add(book);
    return library;
  }

  public void addBooksToLibrary(Book... newBooks) {
    books.addAll(Arrays.asList(newBooks));
  }

  public void displayAllBooks() {
    books.stream().map(Book::getInfo).forEach(System.out::println);
  }

  public boolean removeBookFromLibrary(String isbn) {
    return books.removeIf(book -> book.getInfo().contains(isbn));
  }

  public Book findBookByISBN(String isbn) throws NoBookFoundException {
    return books.stream()
        .filter(book -> book.getIsbn().equals(isbn))
        .findAny()
        .orElseThrow(() -> new NoBookFoundException("Book not found"));
  }

  @Override
  public String toString() {
    return "\nName: " + name + ",\n Collection of Books: " + getBooks().toString();
  }

  public static void libraryMenu(Library library) throws NoBookFoundException {
    Scanner scan = new Scanner(System.in);
    int userChoice;
    boolean running = true;

    while (running) {

      System.out.println("Welcome to the Library!");
      System.out.println(
          "These are your options: \n 1. Add Book\n 2. Remove Book\n 3. Display All Books\n 4. Find Book by ISBN\n 5. Exit");

      while (true) {
        System.out.print("Enter your choice: ");

        if (scan.hasNextInt()) {
          userChoice = scan.nextInt();
          break;
        } else {
          System.out.println("Invalid choice. Try again.");
          scan.next();
        }
      }

      scan.nextLine(); // Add this line to consume the newline

      switch (userChoice) {
        case 1:
          System.out.println("Enter title: ");
          String title = scan.nextLine();

          System.out.println("Enter author: ");
          String author = scan.nextLine();

          System.out.println("Enter ISBN: ");
          String isbn = scan.nextLine();

          Book newBook = new Book(title, author, isbn);
          Library updatedLibrary = library.addBookToLibrary(newBook, library);
          libraryMenu(updatedLibrary);
        case 2:
          System.out.println("Enter ISBN: ");
          String removeBookByIsbn = scan.nextLine();
          boolean result = library.removeBookFromLibrary(removeBookByIsbn);
          if (result) {
            System.out.println("Book removed.");
          } else {
            System.out.println("Book not found.");
          }
          libraryMenu(library);
        case 3:
          library.displayAllBooks();
          libraryMenu(library);
        case 4:
          System.out.println("Enter ISBN: ");
          String findBookByISBN = scan.nextLine();
          Book foundBook = library.findBookByISBN(findBookByISBN);
          System.out.println(foundBook.getInfo());
          libraryMenu(library);
        case 5:
          running = false;
          break;
        default:
          System.out.println("Invalid choice. Try again.");
      }
    }
    System.out.println("Thank you for using Library!");
  }

  public static void main(String[] args) throws NoBookFoundException {

    Library library = new Library("Ryner's Library");
    libraryMenu(library);
  }
}
