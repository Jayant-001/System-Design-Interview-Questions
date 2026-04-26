package spotAllocation;

import java.util.List;

import model.ParkingSpot;
import model.VehicleType;

public interface SpotAllocationStrategy {
    
    public ParkingSpot getSpot(List<List<ParkingSpot>> parkingSpots, VehicleType type);
}
