package fairCalculation;

import model.Ticket;
import model.VehicleType;

public class StandardFairCalculation implements FairCalculationStrategy {

    @Override
    public double calculateFare(Ticket ticket) {
        switch(ticket.getSpot().getVehicleType()) {
            case VehicleType.TWO_WHEELER:
                return 100;
            case VehicleType.FOUR_WHEELER:
                return 200;
            case VehicleType.EIGHT_WHEELER:
                return 300;
            default:
                return 0;
        }
    }
}
