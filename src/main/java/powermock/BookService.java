package powermock;

public class BookService {
    private BookRepository bookRepository;

    public Book findBook(int bookId) {
        log(bookId);
        return findBookPvt(bookId);
    }

    private Book findBookPvt(int bookId) {
        return bookRepository.findBook(bookId);
    }

    private void log(int bookId) {
        // log method call request
    }


}
