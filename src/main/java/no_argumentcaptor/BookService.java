package no_argumentcaptor;

public class BookService {
    private BookRepository bookRepository;

    public boolean addBookBoolean(BookRequest bookRequest) {
        Book book = new Book(1, bookRequest.getName(), bookRequest.getPrice());
        return bookRepository.addBookBoolean(book);
    }

    public void addBookVoid(BookRequest bookRequest) {
        Book book = new Book(1, bookRequest.getName(), bookRequest.getPrice());
        bookRepository.addBookVoid(book);
    }



}
