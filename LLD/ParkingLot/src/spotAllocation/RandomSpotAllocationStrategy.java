package spotAllocation;

import java.util.List;

import model.ParkingSpot;
import model.VehicleType;

public class RandomSpotAllocationStrategy implements SpotAllocationStrategy {

    @Override
    public ParkingSpot getSpot(List<List<ParkingSpot>> parkingSpots, VehicleType type) {

        for(int i = 0; i < parkingSpots.size(); i++) {
            for(int j = 0; j < parkingSpots.get(i).size(); j++) {
                ParkingSpot spot = parkingSpots.get(i).get(j);
                if(spot.getVehicleType() == type && spot.tryOccupy()) {
                    return spot;
                }
            }
        }

        return null;
    }
}
