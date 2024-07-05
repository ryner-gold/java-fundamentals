import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LibraryTwo {
  private String name;
  private ArrayList<Book> books;

  public LibraryTwo(String name) {
    this.name = name;
    // Pre-initialize with mock data
    this.books =
        new ArrayList<>(
            Arrays.asList(
                new Book("1984", "George Orwell", "9780451524935"),
                new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")));
  }

  // Method 1: Simple add
  public void addBook(Book book) {
    books.add(book);
  }

  // Method 2: Add multiple books using a stream
  public void addBooksStream(Book... newBooks) {
      books.addAll(Arrays.asList(newBooks));
  }

  // Method 3: Create a new ArrayList using streams
  public void addBooksNewList(Book... newBooks) {
    books =
        Stream.concat(books.stream(), Stream.of(newBooks))
            .collect(Collectors.toCollection(ArrayList::new));
  }

  // Method 4: Using addAll
  public void addBooksAll(Book... newBooks) {
    books.addAll(Arrays.asList(newBooks));
  }

  public void displayBooks() {
    books.forEach(book -> System.out.println(book.getInfo()));
  }

  // Getter for books (returns a copy to preserve encapsulation)
  public ArrayList<Book> getBooks() {
    return new ArrayList<>(books);
  }
}
