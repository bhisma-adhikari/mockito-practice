package argumentcaptor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTestWithoutAnnotation {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testAddBookBoolean() {
        BookRequest bookRequest = new BookRequest("Physics", 100);
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        when(bookRepository.addBookBoolean(bookArgumentCaptor.capture())).thenReturn(true);
        assertTrue(bookService.addBookBoolean(bookRequest));
    }

    @Test
    public void testAddBookVoid() {
        BookRequest bookRequest = new BookRequest("Physics", 100);
        ArgumentCaptor<Book> bookArgumentCaptor = ArgumentCaptor.forClass(Book.class);
        bookService.addBookVoid(bookRequest);
        // this only verifies that bookRepository.addBookVoid() was called,
        // but it does not verifies the argument passed to bookRepository.addBookVoid()
        // was what we desired
        verify(bookRepository).addBookVoid(bookArgumentCaptor.capture());
        Book book = bookArgumentCaptor.getValue();
        // this is to verify that the argument passed to bookRepository.addBookVoid()
        // was what we wanted to be
        assertEquals(book.getName(), "Physics");
    }

}
