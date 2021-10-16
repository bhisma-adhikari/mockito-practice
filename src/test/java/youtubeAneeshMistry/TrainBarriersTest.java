package youtubeAneeshMistry;

import mypkg.Adder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

@ExtendWith(MockitoExtension.class)
public class TrainBarriersTest {

    @InjectMocks
    TrainBarriers trainBarriers;

    @Mock
    PassengerRepository passengerRepository;

    @Mock
    EmailService emailService;


    @Test
    public void testPassengerEntry() {
        int PASSENGER_ID = 3;
        trainBarriers.passengerEntry(PASSENGER_ID);
        Mockito.verify(passengerRepository).registerPassenger(PASSENGER_ID);
        Mockito.verify(emailService).notifyPassenger(PASSENGER_ID);
    }


}
