package mypkg1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class PersonTest {
    @InjectMocks Person person;

    @Mock
    StringWrapper firstName;

    @Mock
    StringWrapper lastName;



    @Test
    public void testGetName() {
        // if argument types were different, this would not be needed
        // because Mockito would then be able to resolve the arguments based on
        // their type.
        person = new Person(firstName, lastName);

        when(firstName.toString()).thenReturn("John");
        when(lastName.toString()).thenReturn("Doe");
        Assertions.assertEquals("John Doe", person.getName());

    }
}

//// this works fine
//public class PersonTest {
//    @Test
//    public void testGetName() {
//        StringWrapper firstName = mock(StringWrapper.class);
//        StringWrapper lastName = mock(StringWrapper.class);
//        Person person = new Person(firstName, lastName);
//        when(firstName.toString()).thenReturn("John");
//        when(lastName.toString()).thenReturn("Doe");
//        assertEquals("John Doe", person.getName());
//
//    }
//}