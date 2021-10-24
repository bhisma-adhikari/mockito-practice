package misc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testFindBook() {
        Book book = new Book(1, "Physics", 100);

//        when(bookRepository.findBook(1)).thenReturn(book);
//        assertEquals(book, bookService.findBook(1));

//        when(bookRepository.findBook(anyInt())).thenReturn(book);
//        assertEquals(book, bookService.findBook(anyInt()));

        when(bookRepository.findBook(1)).thenReturn(book);
        assertEquals(book, bookService.findBook(1));





//        when(bookRepository.findBook(eq(1))).thenReturn(book);
//        assertEquals(book, bookService.findBook(anyInt()));

//        assertEquals(book, bookService.findBook(eq(1)));
    }




}
