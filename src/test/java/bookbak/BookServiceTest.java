package bookbak;

import bookbak.Book;
import bookbak.BookRepository;
import bookbak.BookService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testSaveBook() {
        Book book = new Book("Physics", 123);
        bookService.saveBook(book);
        verify(bookRepository).saveBook(book);
    }

    @Test
    public void testSaveBookDuplicate() {
        Book book = new Book("Physics", 123);

        bookService.saveBookDuplicate(book);
        verify(bookRepository).saveBook(book);
    }
}
