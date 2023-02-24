package services;

import java.time.Duration;

import entities.CarRental;
import entities.Invoice;

public class RentalService {
    private double pricePerHour;
    private double pricePerDay;
    private BrazilTaxService brTaxService;

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public BrazilTaxService getBrTaxService() {
        return brTaxService;
    }

    public void setBrTaxService(BrazilTaxService brTaxService) {
        this.brTaxService = brTaxService;
    }

    public void processInvoice(CarRental carRental) {

        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double duration = Math.ceil(minutes / 60);

        double basicPayment = duration <= 12 ? duration * pricePerHour : Math.ceil(duration / 24) * pricePerDay;
        double tax = brTaxService.tax(basicPayment);

        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    public RentalService(double pricePerHour, double pricePerDay, BrazilTaxService brTaxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.brTaxService = brTaxService;
    }
}
