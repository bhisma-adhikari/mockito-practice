package exceptionhandling;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class BookService {
    private BookRepository bookRepository;


    public int getTotalPrice() throws SQLException {
        List<Book> books = bookRepository.findAllBooks();
        return books.stream().mapToInt(Book::getPrice).sum();
    }

    public void addBook(Book book) throws SQLException{
        bookRepository.addBook(book);
    }

}
