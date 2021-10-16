package spy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookManagerTest {
    @InjectMocks
    BookManager bookManager;

    @Spy
    BookService bookService;

    @Test
    public void testApplyDiscountOnBook() {
        // we need mock for BookManager.findBook() because BookManager.findBook() to avoid fetching book from database
        // we only need to spy (i.e. use the same logic implemented there) BookManager.getAppliedDiscount()
        Book book = new Book(1, "Physics", 100);

        // Unlike mock, for spy when...thenReturn and doReturn...when behave differently
        // This is because mockito actually runs the code inside these methods
        // So, to avoid problems, for spying, use doReturn...when rather than when...thenReturn

//        when(bookService.findBook(1)).thenReturn(book);  // this is problematic if BookService.findBook() throws some Exception (see implementation -- it throws RunTimeException
        doReturn(book).when(bookService).findBook(1);  // this is ALWAYS okay
        double discountedPrice = bookManager.applyDiscountOnBook(1, 10);
        assertEquals(90, discountedPrice);
    }


}
