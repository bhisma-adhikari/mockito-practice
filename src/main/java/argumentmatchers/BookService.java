package argumentmatchers;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class BookService {
    private BookRepository bookRepository;

    public Book findBook(int bookId) {
        return bookRepository.findBook(bookId);
    }

    public Book findBookByNameAndPrice(String name, double price) {
        return bookRepository.findBookByNameAndPrice(name, price);
    }


    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public boolean isPhysicsOrChemistry(String name) {
        return bookRepository.isPhysicsOrChemistry(name);
    }


}
