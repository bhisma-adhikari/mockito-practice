package argumentmatchers;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
    Book findBook(int bookId);

    Book findBookByNameAndPrice(String name, double price);

    void addBook(Book book);

    boolean isPhysicsOrChemistry(String name);
}
