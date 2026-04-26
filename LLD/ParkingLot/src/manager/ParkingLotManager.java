package manager;

import fairCalculation.FairCalculationStrategy;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;

public class ParkingLotManager {
    
    private final SpotManager spotManager;
    private final FairCalculationStrategy fairCalculationStrategy;
    
    public ParkingLotManager(SpotManager spotManager, FairCalculationStrategy fairCalculationStrategy) {
        this.spotManager = spotManager;
        this.fairCalculationStrategy = fairCalculationStrategy;
    }

    public Ticket park(Vehicle vehicle) {

        ParkingSpot spot = spotManager.getSpot(vehicle);
        if(spot == null) {
            throw new IllegalStateException("Parking lot is full for this vehicle type = " + vehicle.getType());
        }
        return new Ticket(spot, vehicle);
    }

    public boolean unpark(Ticket tikcet) {
        return tikcet.getSpot().tryFree();
    }

    public double calculateFare(Ticket ticket) {

        return fairCalculationStrategy.calculateFare(ticket);
    }
}
