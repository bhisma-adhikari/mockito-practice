package mypkg;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {
    @InjectMocks
    private Calculator calculator;

    @Mock
    private Adder adder;

    @Mock
    private Logger logger;

    @Test
    void testAdd() {
        when(adder.add(1, 2)).thenReturn(3);
//        doReturn(3).when(adder).add(1,2);
        assertEquals(3, calculator.add(1, 2));
    }

    @Test
    void testLog() {
        calculator.log("log string");
        verify(logger).log("log string");
    }

    @Test
    void testLog1() {
        doNothing().when(logger).log("log string");
        calculator.log("log string");
    }


}
