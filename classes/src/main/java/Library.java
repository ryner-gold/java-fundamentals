import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public record Library(String name, ArrayList<Book> collectionOfBooks) {

  public Library(String name, ArrayList<Book> collectionOfBooks) {
    this.name = name;
    this.collectionOfBooks =  new ArrayList<>(
            Arrays.asList(
                    new Book("1984", "George Orwell", "9780451524935"),
                    new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"),
                    new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")));;
  }

  public void addBookToLibrary(Book book) {
    collectionOfBooks.add(book);
  }

  public void addBooksToLibrary(Book... books) {
    Collections.addAll(collectionOfBooks, books);
  }

  public void displayAllBooks() {
    collectionOfBooks.stream().map(Book::getInfo).forEach(System.out::println);
  }

  public boolean removeBookFromLibrary(String isbn) {
    return collectionOfBooks.removeIf(book -> book.getInfo().contains(isbn));
  }

  public Book findBookByISBN(String isbn) throws NoBookFoundException {
    return collectionOfBooks.stream()
        .filter(book -> book.getInfo().contains(isbn))
        .findAny()
        .orElseThrow(() -> new NoBookFoundException("Book not found"));
  }

  public static void libraryMenu() throws NoBookFoundException {
    int userChoice;
    Scanner scan = new Scanner(System.in);
    ArrayList<Book> initialBooks =
        new ArrayList<>(
            Arrays.asList(
                new Book("1984", "George Orwell", "9780451524935"),
                new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")));
    Library library = new Library("Ryner's Library", initialBooks);

    System.out.println("Welcome to the Library!");
    System.out.println(
        "These are your options: \n 1. Add Book\n 2. Remove Book\n 3. Display All Books\n 4. Find Book by ISBN\n 5. Exit");

    while(true){
      System.out.print("Enter your choice: ");

      if(scan.hasNextInt()){
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
        library.addBookToLibrary(newBook);
        libraryMenu();
      case 2:
        String removeBookByIsbn = scan.nextLine();
        boolean result = library.removeBookFromLibrary(removeBookByIsbn);
        if (result){
          System.out.println("Book removed.");
        } else {
          System.out.println("Book not found.");
        }
        libraryMenu();
      case 3:
        library.displayAllBooks();
        libraryMenu();
      case 4:
        String findBookByISBN = scan.nextLine();
        Book foundBook = library.findBookByISBN(findBookByISBN);
        System.out.println(foundBook.getInfo());
        libraryMenu();
      case 5:
        break;
    }
    System.out.println("Thank you for using Library!");
  }

  public static void main(String[] args) throws NoBookFoundException {

    libraryMenu();
  }
}
