package main;

import mypkg1.StringWrapper;

import java.time.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime currentDeliveryDate = now.plusDays(5).with(LocalTime.MIDNIGHT);
        LocalDateTime originalDeliveryDate = now.plusDays(5).with(LocalTime.MIDNIGHT);
        String currentDeliveryDateString = currentDeliveryDate.toString() + ":00";
        String originalDeliveryDateString = originalDeliveryDate.toString() + ":00";

        System.out.println(currentDeliveryDateString);
        System.out.println(originalDeliveryDateString);

    }

}
