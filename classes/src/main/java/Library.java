import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Library {
  private final String name;
  private final ArrayList<Book> collectionOfBooks;

  public String getName() {
    return name;
  }

  public ArrayList<Book> getCollectionOfBooks() {
    return collectionOfBooks;
  }

  public Library(String name, ArrayList<Book>  collectionOfBooks) {
    this.name = name;
    this.collectionOfBooks = collectionOfBooks;
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

  public void removeBookFromLibrary(String isbn) {
    collectionOfBooks.removeIf(book -> book.getInfo().contains(isbn));
  }

  public Book findBookByISBN(String isbn) {
    return collectionOfBooks.stream()
            .filter(book -> book.getInfo()
                    .contains(isbn))
            .findAny()
            .orElse(null);
  }

  public static void main(String[] args) {
Scanner scan = new Scanner(System.in);
    // Make a book
    Book exampleBook = new Book("To Kill a Mockingbird", "Harper Lee", "0001");
    Book exampleBook2 = new Book("An Inspector Calls", "J.B Priestley", "0002");
    Book exampleBook3 = new Book("The Bible", "God", "0003");

    // Make a library
    ArrayList<Book> collection = new ArrayList<>();
    Library exampleLibrary = new Library("Ryner's Library", collection);

    exampleLibrary.addBookToLibrary(exampleBook);
    exampleLibrary.addBooksToLibrary(exampleBook, exampleBook2, exampleBook3);
    exampleLibrary.displayAllBooks();
    exampleLibrary.removeBookFromLibrary("0001");

    System.out.print("Enter book you want to find by ISBN: ");
    String userInputISBN = scan.nextLine();

    Book foundBook = exampleLibrary.findBookByISBN(userInputISBN);
    System.out.println("Found book: " + foundBook.getInfo());
    System.out.println(collection.size());
  }
}
