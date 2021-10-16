package exceptionhandling;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    List<Book> findAllBooks() throws SQLException;
    int getTotalPrice();
    void addBook(Book book) throws SQLException;
}
