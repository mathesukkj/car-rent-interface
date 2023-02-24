import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import entities.CarRental;
import entities.Vehicle;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the rent data ");
        System.out.print("Car model: ");
        Vehicle vehicle = new Vehicle(s.nextLine());
        System.out.print("Removal (dd/MM/yyyy HH:mm): ");
        LocalDateTime start = LocalDateTime.parse(s.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.print("Return (dd/MM/yyyy HH:mm): ");
        LocalDateTime finish = LocalDateTime.parse(s.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.print("Price per hour: ");
        double pricePerHour = s.nextDouble();
        System.out.print("Price per day: ");
        double pricePerDay = s.nextDouble();

        CarRental rent = new CarRental(start, finish, vehicle);

        s.close();
    }
}
