package book;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test void testSaveBook() {
        Book book = new Book(1, "Physics", 12);
        bookService.saveBook(book);
        verify(bookRepository).saveBook(book);
    }

    @Test
    public void testSaveBookConditional() {
        Book book = new Book(1, "Physics", -12);
        bookService.saveBookConditional(book);
//        verify(bookRepository).saveBook(book);
//        verify(bookRepository, times(2)).saveBook(book);
        verify(bookRepository, never()).saveBook(book);
    }

    @Test
    public void testUpdatePrice() {
        Book book = new Book(1, "Physics", 12);
        when(bookRepository.findById(1)).thenReturn(book);
        bookService.updatePrice(1, 1200);
        assertEquals(1200, book.getPrice());
        verify(bookRepository).saveBook(book);
    }

    @Test
    public void testUpdatePriceNull() {
        Book book = mock(Book.class);
        verifyZeroInteractions(bookRepository);
        verifyZeroInteractions(book);
    }

    @Test
    public void testUpdatePriceSamePrice() {
        Book book = new Book(1, "Physics", 12);
        when(bookRepository.findById(1)).thenReturn(book);
        bookService.updatePrice(1, 12);
        verify(bookRepository).findById(1);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void testUpdatePriceInOrder() {
        Book book = new Book(1, "Physics", 12);
        when(bookRepository.findById(1)).thenReturn(book);
        bookService.updatePrice(1, 120);

        InOrder inOrder = Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findById(1);
        inOrder.verify(bookRepository).saveBook(book);
    }



}
