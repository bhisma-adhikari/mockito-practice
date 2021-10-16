package spy;

public class BookService {

    public Book findBook(int bookId) {
        // should actually return a book from database
        throw new RuntimeException("Method not implemented");
    }

    public double getAppliedDiscount(Book book, double discountRate) {
        return book.getPrice() * (1 - discountRate / 100);
    }
}
