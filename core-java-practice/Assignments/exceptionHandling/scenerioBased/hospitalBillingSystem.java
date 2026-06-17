package exceptionHandling.scenerioBased;

class InsufficientFundsException extends Exception {
  public InsufficientFundsException(String message) {
    super(message);
  }
}

public class hospitalBillingSystem {
  private static final int MAX_PATIENTS = 100;
  private double[] patientBills = new double[MAX_PATIENTS];
  private int patientCount = 0;

  public void addPatient(double billAmount) {
    if (patientCount < MAX_PATIENTS) {
      patientBills[patientCount] = billAmount;
      patientCount++;
    }
  }

  public double calculateAverageBill(int numItems) {
    try {
      if (numItems == 0) {
        throw new ArithmeticException("Cannot calculate average: zero items provided");
      }
      double total = 0;
      for (int i = 0; i < numItems; i++) {
        total += patientBills[i];
      }
      return total / numItems;
    } catch (ArrayIndexOutOfBoundsException e) {
      throw new RuntimeException("Invalid patient index: requested index exceeds available patient records", e);
    } catch (ArithmeticException e) {
      throw new RuntimeException("Billing calculation error: " + e.getMessage(), e);
    }
  }

  public void processPayment(String amountStr, double availableFunds) throws InsufficientFundsException {
    try {
      double paymentAmount = Double.parseDouble(amountStr);
      if (paymentAmount > availableFunds) {
        throw new InsufficientFundsException(
            "Insufficient funds: required " + paymentAmount + ", available " + availableFunds);
      }
    } catch (NumberFormatException e) {
      throw new RuntimeException("Invalid payment amount format: '" + amountStr + "' is not a valid number", e);
    }
  }

  public static void main(String[] args) {
    hospitalBillingSystem system = new hospitalBillingSystem();

    system.addPatient(500.0);
    system.addPatient(300.0);
    system.addPatient(750.0);

    try {
      double avg = system.calculateAverageBill(3);
      System.out.println("Average bill: " + avg);
    } catch (RuntimeException e) {
      System.err.println("Error calculating average: " + e.getMessage());
    }

    try {
      system.calculateAverageBill(0);
    } catch (RuntimeException e) {
      System.err.println("Error: " + e.getMessage());
    }

    try {
      system.processPayment("1000", 500);
    } catch (InsufficientFundsException e) {
      System.err.println("Payment error: " + e.getMessage());
    }

    try {
      system.processPayment("invalid", 1000);
    } catch (RuntimeException e) {
      System.err.println("Error processing payment: " + e.getMessage());
    }
  }
}
