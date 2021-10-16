package no_argumentcaptor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testAddBookBoolean() {
        BookRequest bookRequest = new BookRequest("Physics", 100);
        Book book = new Book(1, "Physics", 100);
        when(bookRepository.addBookBoolean(book)).thenReturn(true);
        assertTrue(bookService.addBookBoolean(bookRequest));
    }

    @Test
    public void testAddBookVoid() {
        BookRequest bookRequest = new BookRequest("Physics", 100);
        Book book = new Book(1, "Physics", 100);
        bookService.addBookVoid(bookRequest);
        verify(bookRepository).addBookVoid(book);
    }

}
