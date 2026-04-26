package manager;

import java.util.List;

import model.ParkingSpot;
import model.Vehicle;
import spotAllocation.SpotAllocationStrategy;

public class SpotManager {
    private final List<List<ParkingSpot>> parkingSpots;
    private final SpotAllocationStrategy spotAllocationStrategy;

    public SpotManager(List<List<ParkingSpot>> parkingSpots, SpotAllocationStrategy spotAllocationStrategy) {
        this.parkingSpots = parkingSpots;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public ParkingSpot getSpot(Vehicle vehicle) {

        return spotAllocationStrategy.getSpot(parkingSpots, vehicle.getType());
    }
}
