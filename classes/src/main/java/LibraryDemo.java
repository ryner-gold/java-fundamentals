public class LibraryDemo {
    public static void main(String[] args) {
        LibraryTwo library = new LibraryTwo("My Library");

        // Method 1: Simple add
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));

        // Method 2: Add multiple books using a stream
        library.addBooksStream(
                new Book("To Kill a Mockingbird", "Harper Lee", "9780446310789"),
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565")
        );

        // Method 3: Create a new ArrayList using streams
        library.addBooksNewList(
                new Book("Pride and Prejudice", "Jane Austen", "9780141439518"),
                new Book("The Catcher in the Rye", "J.D. Salinger", "9780316769174")
        );

        // Method 4: Using addAll
        library.addBooksAll(
                new Book("The Hobbit", "J.R.R. Tolkien", "9780547928227"),
                new Book("The Da Vinci Code", "Dan Brown", "9780307474278")
        );

        System.out.println("Books in the library:");
        library.displayBooks();

        System.out.println("\nNumber of books: " + library.getBooks().size());
    }
}