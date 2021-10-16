package book;

public class BookService {
    private BookRepository bookRepository;

    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    public void saveBookConditional(Book book) {
        if (book.getPrice() < 0) {
            return;
        } else if (book.getPrice() < 100) {
            bookRepository.saveBook(book);
        } else {
            bookRepository.saveBook(book);
            bookRepository.saveBook(book);
        }
    }

    public void updatePrice(Integer bookId, int newPrice) {
        if (bookId == null) return;
        Book book = bookRepository.findById(bookId);
        if (book.getPrice() == newPrice)
            return;
        book.setPrice(newPrice);
        bookRepository.saveBook(book);
    }
}
