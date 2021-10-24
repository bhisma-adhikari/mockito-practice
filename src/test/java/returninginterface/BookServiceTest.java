package returninginterface;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testGetBook() {
        Book book = new Book() {};
        when(bookRepository.getBook()).thenReturn(book);
        Book returnedBook = bookRepository.getBook();
        // cannot do assertEquals to compare a class and an interface, so we use 'instanceof' instead
        assertTrue(bookService.getBook() instanceof Book);
    }
}
