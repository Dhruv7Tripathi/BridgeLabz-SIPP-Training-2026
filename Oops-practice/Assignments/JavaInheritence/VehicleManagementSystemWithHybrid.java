// Superclass Vehicle
class Vehicle {
  protected String model;
  protected double maxSpeed;

  public Vehicle(String model, double maxSpeed) {
    this.model = model;
    this.maxSpeed = maxSpeed;
  }

  public void displayInfo() {
    System.out.println("Model: " + model);
    System.out.println("Max Speed: " + maxSpeed + " km/h");
  }

  public String getModel() {
    return model;
  }

  public double getMaxSpeed() {
    return maxSpeed;
  }
}

// Interface Refuelable
interface Refuelable {
  void refuel(double amount);
}

// Subclass ElectricVehicle
class ElectricVehicle extends Vehicle {
  private double batteryCapacity;

  public ElectricVehicle(String model, double maxSpeed, double batteryCapacity) {
    super(model, maxSpeed);
    this.batteryCapacity = batteryCapacity;
  }

  public void charge() {
    System.out.println(model + " is charging...");
  }

  public double getBatteryCapacity() {
    return batteryCapacity;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    System.out.println("Type: Electric Vehicle");
  }
}

// Subclass PetrolVehicle implementing Refuelable (Hybrid Inheritance)
class PetrolVehicle extends Vehicle implements Refuelable {
  private double fuelTankCapacity;
  private double currentFuel;

  public PetrolVehicle(String model, double maxSpeed, double fuelTankCapacity) {
    super(model, maxSpeed);
    this.fuelTankCapacity = fuelTankCapacity;
    this.currentFuel = 0;
  }

  @Override
  public void refuel(double amount) {
    if (currentFuel + amount <= fuelTankCapacity) {
      currentFuel += amount;
      System.out.println(model + " refueled with " + amount + " liters. Current fuel: " + currentFuel + " liters");
    } else {
      System.out.println("Cannot refuel. Tank capacity exceeded!");
    }
  }

  public double getCurrentFuel() {
    return currentFuel;
  }

  public double getFuelTankCapacity() {
    return fuelTankCapacity;
  }

  @Override
  public void displayInfo() {
    super.displayInfo();
    System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    System.out.println("Current Fuel: " + currentFuel + " liters");
    System.out.println("Type: Petrol Vehicle");
  }
}

// Main class to demonstrate hybrid inheritance
public class VehicleManagementSystemWithHybrid {
  public static void main(String[] args) {
    // Create an ElectricVehicle
    ElectricVehicle tesla = new ElectricVehicle("Tesla Model 3", 225, 75);
    System.out.println("=== Electric Vehicle ===");
    tesla.displayInfo();
    tesla.charge();
    System.out.println();

    // Create a PetrolVehicle
    PetrolVehicle sedan = new PetrolVehicle("Honda Accord", 210, 60);
    System.out.println("=== Petrol Vehicle ===");
    sedan.displayInfo();
    sedan.refuel(50);
    System.out.println();

    // Demonstrate Refuelable interface
    Refuelable refuelableVehicle = sedan;
    System.out.println("=== Using Refuelable Interface ===");
    refuelableVehicle.refuel(10);
    System.out.println();

    // Create another PetrolVehicle
    PetrolVehicle suv = new PetrolVehicle("Toyota Fortuner", 190, 80);
    System.out.println("=== Another Petrol Vehicle ===");
    suv.displayInfo();
    suv.refuel(75);
  }
}
