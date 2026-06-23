
import java.util.*;

class InsufficientFundsException extends Exception {
  public InsufficientFundsException(String message) {
    super(message);
  }
}

public class hospitalBillingSystem {
  private List<Patient> patients = new ArrayList<>();

  static class Patient {
    String name;
    double balance;
    List<Double> bills;

    Patient(String name, double balance) {
      this.name = name;
      this.balance = balance;
      this.bills = new ArrayList<>();
    }
  }

  public void addPatient(String name, double balance) {
    patients.add(new Patient(name, balance));
  }

  public void addBill(int patientIndex, double amount) {
    try {
      if (patientIndex < 0 || patientIndex >= patients.size()) {
        throw new ArrayIndexOutOfBoundsException("Invalid patient index: " + patientIndex);
      }
      patients.get(patientIndex).bills.add(amount);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Error: " + e.getMessage());
    }
  }

  public double getAverageBill(int patientIndex) {
    try {
      if (patientIndex < 0 || patientIndex >= patients.size()) {
        throw new ArrayIndexOutOfBoundsException("Invalid patient index: " + patientIndex);
      }
      Patient patient = patients.get(patientIndex);
      if (patient.bills.isEmpty()) {
        throw new ArithmeticException("Division by zero: patient has no bills");
      }
      double sum = patient.bills.stream().mapToDouble(Double::doubleValue).sum();
      return sum / patient.bills.size();
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Error: " + e.getMessage());
      return 0;
    } catch (ArithmeticException e) {
      System.err.println("Error: " + e.getMessage());
      return 0;
    }
  }

  public void processPayment(int patientIndex, String amountStr) {
    try {
      if (patientIndex < 0 || patientIndex >= patients.size()) {
        throw new ArrayIndexOutOfBoundsException("Invalid patient index: " + patientIndex);
      }
      double amount = Double.parseDouble(amountStr);
      Patient patient = patients.get(patientIndex);
      if (patient.balance < amount) {
        throw new InsufficientFundsException("Insufficient funds for patient " + patient.name +
            ": balance=" + patient.balance + ", requested=" + amount);
      }
      patient.balance -= amount;
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println("Error: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("Error: Invalid amount format - " + amountStr);
    } catch (InsufficientFundsException e) {
      System.err.println("Payment Error: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    hospitalBillingSystem system = new hospitalBillingSystem();
    system.addPatient("John Doe", 5000);
    system.addBill(0, 500);
    system.addBill(0, 300);
    system.getAverageBill(0);
    system.processPayment(0, "2000");
    system.processPayment(0, "invalid");
    system.processPayment(0, "10000");
    system.processPayment(5, "100");
  }
}
