package powermock;

public interface BookRepository {
    Book findBook(int bookId);

    Book findBookByNameAndPrice(String name, double price);

    void addBook(Book book);

    boolean isPhysicsOrChemistry(String name);
}
