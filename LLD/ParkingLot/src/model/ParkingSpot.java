package model;

import java.util.concurrent.atomic.AtomicBoolean;

public class ParkingSpot {
    private final VehicleType vehicleType;
    private final String level;
    private final String spotNumber;
    private AtomicBoolean isAvailable;

    public ParkingSpot(VehicleType vehicleType, String level, String spotNumber) {
        this.vehicleType = vehicleType;
        this.level = level;
        this.spotNumber = spotNumber;
        this.isAvailable = new AtomicBoolean(true);
    }

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public String getLevel() {
        return this.level;
    }

    public String getSpotNumber() {
        return this.spotNumber;
    }

    public boolean tryOccupy() {
        return this.isAvailable.compareAndSet(true, false);
    }

    public boolean tryFree() {
        return this.isAvailable.compareAndSet(false, true);
    }

    @Override
    public String toString() {
        return String.format("VehicleType=%s Level=%s SpotNumber=%s", this.vehicleType, this.level, this.spotNumber);
    }
}
