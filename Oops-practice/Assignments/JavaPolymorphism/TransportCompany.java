public class TransportCompany {

  public static void main(String[] args) {
    Vehicle[] fleet = {
        new Car(),
        new Bus(),
        new Bike(),
        new ElectricCar()
    };

    int km = 100;
    for (Vehicle vehicle : fleet) {
      System.out.println(vehicle.getClass().getSimpleName() + " fuel cost for " + km + " km: " + vehicle.fuelCost(km));

      if (vehicle instanceof Car) {
        Car car = (Car) vehicle;
        System.out.println("  Seats: " + car.seats);
      }
    }
  }

  static abstract class Vehicle {
    abstract double fuelCost(int km);
  }

  static class Car extends Vehicle {
    protected int seats = 4;

    @Override
    double fuelCost(int km) {
      return km * 6.5;
    }
  }

  static class Bus extends Vehicle {
    @Override
    double fuelCost(int km) {
      return km * 12.0;
    }
  }

  static class Bike extends Vehicle {
    @Override
    double fuelCost(int km) {
      return km * 2.0;
    }
  }

  static class ElectricCar extends Car {
    @Override
    double fuelCost(int km) {
      return km * 1.2;
    }
  }
}
