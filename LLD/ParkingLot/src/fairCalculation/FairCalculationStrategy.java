package fairCalculation;

import model.Ticket;

public interface FairCalculationStrategy {
    double calculateFare(Ticket ticket);
}
