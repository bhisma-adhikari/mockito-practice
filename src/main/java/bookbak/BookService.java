package bookbak;

public class BookService{
    private BookRepository bookRepository;
    public void saveBook(Book book) {
        bookRepository.saveBook(book);
    }

    public void saveBookDuplicate(Book book) {
        Book newBook = new Book(book.getName(), book.getPrice());
        bookRepository.saveBook(newBook);
    }
}
