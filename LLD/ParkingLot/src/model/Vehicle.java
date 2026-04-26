package model;

public class Vehicle {
    private final VehicleType type;
    private final String vehicleNumber;
    public Vehicle(VehicleType type, String vehicleNumber) {
        this.type = type;
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public String getVehicleNumber() {
        return this.vehicleNumber;
    }

    @Override
    public String toString() {
        return String.format("VehicleType=%s VehicleNumber=%s", this.type, this.vehicleNumber);
    }
}
