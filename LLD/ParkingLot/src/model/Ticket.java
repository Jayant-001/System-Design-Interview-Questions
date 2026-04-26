package model;

import java.time.LocalDateTime;

public class Ticket {
    private final ParkingSpot spot;
    private final LocalDateTime entryTime;
    private final Vehicle vehicle;

    public Ticket(ParkingSpot spot, Vehicle vehicle) {
        this.spot = spot;
        entryTime = LocalDateTime.now();
        this.vehicle = vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    @Override
    public String toString() {
        return String.format("""
            --------------------Ticket-------------------- 
            ParkingSpot: %s
            EntryTime: %s
            Vehicle: %s
            """, spot, entryTime, vehicle);
    }
}
