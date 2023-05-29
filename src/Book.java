import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Book {

    private String title;
    private int pageCount;
    private String author;
    private LocalDate publicationDate;

    public String getTitle() {
        return title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public Book(String title, int pageCount, String author, LocalDate publicationDate) {
        this.title = title;
        this.pageCount = pageCount;
        this.author = author;
        this.publicationDate = publicationDate;
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();

        // Add 10 books to the list
        books.add(new Book("To Kill a Mockingbird", 336, "Harper Lee", LocalDate.of(1960, 7, 11)));
        books.add(new Book("1984", 328, "George Orwell", LocalDate.of(1949, 6, 8)));
        books.add(new Book("The Great Gatsby", 180, "F. Scott Fitzgerald", LocalDate.of(1925, 4, 10)));
        books.add(new Book("Pride and Prejudice", 279, "Jane Austen", LocalDate.of(1813, 1, 28)));
        books.add(new Book("The Catcher in the Rye", 224, "J.D. Salinger", LocalDate.of(1951, 7, 16)));
        books.add(new Book("To the Lighthouse", 209, "Virginia Woolf", LocalDate.of(1927, 5, 5)));
        books.add(new Book("Moby-Dick", 585, "Herman Melville", LocalDate.of(1851, 10, 18)));
        books.add(new Book("Brave New World", 311, "Aldous Huxley", LocalDate.of(1932, 5, 14)));
        books.add(new Book("The Lord of the Rings", 1178, "J.R.R. Tolkien", LocalDate.of(1954, 7, 29)));
        books.add(new Book("Crime and Punishment", 671, "Fyodor Dostoevsky", LocalDate.of(1866, 1, 1)));

        Map<String, String> bookAuthorMap = books.stream()
            .sorted((b1,b2) -> b1.getTitle().compareTo(b2.getTitle()))
            .collect(Collectors.toMap(Book::getTitle, Book::getAuthor, (v1,v2)->v1, LinkedHashMap::new));
        
        System.out.println("Books: ");

        for (Map.Entry<String, String> entry : bookAuthorMap.entrySet()) {
            System.out.println(entry.getKey() + " by " + entry.getValue());
        }

        List<Book> filteredBooks = books.stream()
                .filter(book -> book.getPageCount() > 300)
                .sorted(Comparator.comparing(Book::getPageCount))
                .collect(Collectors.toList());
        System.out.println("\nOver 300 Pages Books: ");

        for (Book book : filteredBooks) {
            System.out.println(book.getTitle() + ", " + book.getPageCount() + " pages");
        }

    }

}
