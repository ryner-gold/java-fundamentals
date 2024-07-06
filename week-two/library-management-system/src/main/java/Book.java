import java.util.Scanner;

public class Book {
  final private String title;
  final private String author;
  final private String isbn;

  public Book(String title, String author, String isbn) {
    this.title = title;
    this.author = author;
    this.isbn = isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getIsbn() {
    return isbn;
  }

//  @Override
//  public String toString() {
//    return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
//  }

  public String getInfo() {
    return "Title: " + this.title + "\nAuthor: " + this.author + "\nISBN: " + this.isbn;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    System.out.print("Enter title: ");
    String userTitle = scan.nextLine();
    System.out.print("Enter author: ");
    String userAuthor = scan.nextLine();

    Book book = new Book(userTitle, userAuthor, "1234");
    Book book2 = new Book("how to be a big boy", "big boy", "1234");
    System.out.println(book.getInfo());
    System.out.println(book2.getInfo());
  }
}
