package exceptionhandling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testGetTotalPrice() throws SQLException {
        Book book = new Book(1, "Physics", 100);
        Book book1 = new Book(2, "Chemistry", 150);
        List<Book> books = Arrays.asList(book, book1);
        when(bookRepository.findAllBooks()).thenReturn(books);
        assertEquals(250, bookService.getTotalPrice());
    }

    @Test
    public void testGetTotalPriceException() throws SQLException {
        Book book = new Book(1, "Physics", 100);
        Book book1 = new Book(2, "Chemistry", 150);
        List<Book> books = Arrays.asList(book, book1);
//        when(bookRepository.findAllBooks()).thenThrow(new SQLException());  // legal
        when(bookRepository.findAllBooks()).thenThrow(SQLException.class);  // also legal

        assertThrows(SQLException.class, () -> bookService.getTotalPrice());
    }

    @Test
    public void testAddBook() throws SQLException {
        Book book = new Book(1, "Physics", 100);
//        when(bookRepository.addBook(book)).thenThrow(SQLException.class);  // illegal
        doThrow(SQLException.class).when(bookRepository).addBook(book);  // legal
        assertThrows(SQLException.class, () -> bookService.addBook(book));
    }





}
