package returninginterface;

public class BookService {
    private BookRepository bookRepository;

    public Book getBook() {
        return bookRepository.getBook();
    }

}
