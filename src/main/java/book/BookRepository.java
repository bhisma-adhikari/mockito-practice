package book;

public interface BookRepository {
    public void saveBook(Book book);
//    public void updatePrice(int bookId, int newPrice);
    public Book findById(int bookId);

}
