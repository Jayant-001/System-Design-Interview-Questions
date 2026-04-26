import java.util.ArrayList;
import java.util.List;

import fairCalculation.FairCalculationStrategy;
import fairCalculation.StandardFairCalculation;
import manager.ParkingLotManager;
import manager.SpotManager;
import model.ParkingSpot;
import model.Ticket;
import model.Vehicle;
import model.VehicleType;
import spotAllocation.RandomSpotAllocationStrategy;
import spotAllocation.SpotAllocationStrategy;

public class App {
    public static void main(String[] args) throws Exception {

        List<List<ParkingSpot>> spots = new ArrayList<>();

        List<ParkingSpot> level1Spots = new ArrayList<>();
        level1Spots.add(new ParkingSpot(VehicleType.TWO_WHEELER, "L1", "1"));
        level1Spots.add(new ParkingSpot(VehicleType.FOUR_WHEELER, "L1", "2"));
        level1Spots.add(new ParkingSpot(VehicleType.EIGHT_WHEELER, "L1", "3"));

        List<ParkingSpot> level2Spots = new ArrayList<>();
        level2Spots.add(new ParkingSpot(VehicleType.TWO_WHEELER, "L2", "1"));
        level2Spots.add(new ParkingSpot(VehicleType.FOUR_WHEELER, "L2", "2"));
        level2Spots.add(new ParkingSpot(VehicleType.EIGHT_WHEELER, "L2", "3"));

        spots.add(level1Spots);
        spots.add(level2Spots);

        SpotAllocationStrategy randomSpotAllocationStrategy = new RandomSpotAllocationStrategy();
        SpotManager spotManager = new SpotManager(spots, randomSpotAllocationStrategy);

        FairCalculationStrategy calculationStrategy = new StandardFairCalculation();

        ParkingLotManager manager = new ParkingLotManager(spotManager, calculationStrategy);

        Vehicle v1 = new Vehicle(VehicleType.TWO_WHEELER, "Bike-101");
        Ticket t1 = manager.park(v1);
        System.out.println("Ticket: " + t1);
        System.out.println("Fair: " + manager.calculateFare(t1));


        Vehicle v2 = new Vehicle(VehicleType.TWO_WHEELER, "Truck-102");
        Ticket t2 = manager.park(v2);
        System.out.println("Ticket: " + t2);
        System.out.println("Fair: " + manager.calculateFare(t2));

        manager.unpark(t2);

        Vehicle v3 = new Vehicle(VehicleType.TWO_WHEELER, "Truck-103");
        Ticket t3 = manager.park(v3);
        System.out.println("Ticket: " + t3);
        System.out.println("Fair: " + manager.calculateFare(t3));
    }
}
