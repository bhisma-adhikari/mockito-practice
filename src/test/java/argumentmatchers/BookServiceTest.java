package argumentmatchers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void testFindBook() {
        Book book = new Book(1, "Physics", 100);
        when(bookRepository.findBook(anyInt())).thenReturn(book);
        assertEquals(book, bookService.findBook(anyInt()));
    }

    @Test
    public void testFindBookByNameAndPrice() {
        Book book = new Book(1, "Physics", 100);
        // invalid use of argument matchers
        // either all or none of the arguments should be supplied as argument matchers
//        when(bookRepository.findBookByNameAndPrice("Physics", anyDouble())).thenReturn(book);

        when(bookRepository.findBookByNameAndPrice(anyString(), anyDouble())).thenReturn(book); // valid use of argument matchers

        // invalid use of argument matchers
        // argument matche eq() cannot be used in assertions; they can be used in stubbing and verification only
//        assertEquals(book, bookService.findBookByNameAndPrice(eq("Physics"), anyDouble()));  // invalid
        assertEquals(book, bookService.findBookByNameAndPrice(anyString(), anyDouble()));  // invalid

//        assertEquals(book, bookService.findBookByNameAndPrice("Physics", 1000));
    }



    @Test
    public void testAddBook() {
        Book book = new Book(1, "Physics", 100);
        bookService.addBook(book);
        // can use argument matchers in verify() [although this test doesn't make much sense]
        verify(bookRepository).addBook(any(Book.class));  // valid
    }

    @Test
    public void testIsPhysicsOrChemistry() {
        List<String> majors = Arrays.asList("Physics", "Chemistry");
        for (String major : majors) {
            System.out.println(major);
            when(bookRepository.isPhysicsOrChemistry(major)).thenReturn((true));
            assertTrue(bookService.isPhysicsOrChemistry(major));
        }
    }

}
