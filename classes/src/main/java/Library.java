import java.util.ArrayList;
import java.util.Arrays;

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

  public void displayAllBooks() {

  }
  
  public static void main(String[] args) {

    // Make a book
    Book exampleBook = new Book("To Kill a Mockingbird", "Harper Lee", "0001");

    // Make a library
    ArrayList<Book> collection = new ArrayList<>();
    Library exampleLibrary = new Library("Ryner's Library", collection);
    System.out.println("collection array size before: " + collection.size());

    exampleLibrary.addBookToLibrary(exampleBook);

    System.out.println("Method 1: ");
    for (Book book : exampleLibrary.getCollectionOfBooks()) {
      System.out.println(book.getInfo());
    }

    System.out.println("Method 2: ");
    collection.forEach(System.out::println);

    System.out.println("Method 3: ");
    collection.stream().map(Book::getInfo).forEach(System.out::println);

    System.out.println("collection array size after: " + collection.size());


  }
}
