package spy;

public class BookManager {
    private BookService bookService;

    public BookManager(BookService bookService) {
        this.bookService = bookService;
    }

    public double applyDiscountOnBook(int bookId, double discountRate) {
        Book book = bookService.findBook(bookId);  // we will mock this behavior
        double discountedPrice = bookService.getAppliedDiscount(book, discountRate); // we will spy (imitate) this behavior
        return discountedPrice;
    }
}
