package youtubeAneeshMistry;

public class TrainBarriers {
    private PassengerRepository passengerRepository;
    private EmailService emailService;

    public TrainBarriers(PassengerRepository passengerRepository, EmailService emailService) {
        this.passengerRepository = passengerRepository;
        this.emailService = emailService;
    }

    public void passengerEntry(int passengerId) {
        passengerRepository.registerPassenger(passengerId);
        emailService.notifyPassenger(passengerId);
    }
}
