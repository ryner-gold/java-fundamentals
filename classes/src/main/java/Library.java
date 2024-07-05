import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
  private final String name;
  private Book[] collectionOfBooks;

  public String getName() {
    return name;
  }

  public Book[] getCollectionOfBooks() {
    return collectionOfBooks;
  }

  public Library(String name, Book[] collectionOfBooks) {
    this.name = name;
    this.collectionOfBooks = collectionOfBooks;
  }

  public void addBookToLibrary(Book book) {

    List<Book> booksAsList = new ArrayList<>(Arrays.asList(collectionOfBooks));

    try {
      booksAsList.add(book);
      collectionOfBooks = booksAsList.toArray(collectionOfBooks);
    } catch (Exception e) {
      System.out.println("Error occurred while adding a book to the library");
    }
  }

  public static void main(String[] args) {

    // Make a book
    Book exampleBook = new Book("To Kill a Mockingbird", "Harper Lee", "0001");

    // Make a library
    Book[] collection = new Book[] {};
    Library exampleLibrary = new Library("Ryner's Library", collection);
    System.out.println("collection array size before: " + collection.length);

    exampleLibrary.addBookToLibrary(exampleBook);

    Book[] newCollection = exampleLibrary.getCollectionOfBooks();

    System.out.println("collection array size after: " + newCollection.length);

    for (int i = 0 ; i < newCollection.length; i++) {
      Book element = newCollection[i];
      System.out.println("Book " + (i+1) + ": {\n" + element.getInfo() + "\n}");
    }

  }
}
