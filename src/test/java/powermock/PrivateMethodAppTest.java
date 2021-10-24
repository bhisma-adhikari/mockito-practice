package powermock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.reflect.Whitebox;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PrivateMethodAppTest {
    @InjectMocks
    PrivateMethodApp app;

    // for this to work, the argument in PrivateMethodApp.pvMethod() must be non-primitive type (Integer, not int)
//    @Test
//    public void testPrivateMethodUsingReflection() throws NoSuchMethodException, SecurityException,
//            IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//        Method method = PrivateMethodApp.class.getDeclaredMethod("pvMethod", Integer.class);
//        method.setAccessible(true);
//        method.invoke(app, 10);
//    }

    @Test
    public void testPrivateMethodUsingPowerMock() throws Exception {
        assertEquals((Integer)20, Whitebox.invokeMethod(app, "pvMethod", 10, 20));
    }

}
