package misc;

public class BookService {
    private BookRepository bookRepository;

    public Book findBook(int bookId) {
        return bookRepository.findBook(bookId);
    }
}
