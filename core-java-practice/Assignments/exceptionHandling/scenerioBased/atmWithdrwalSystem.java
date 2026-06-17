public class atmWithdrwalSystem {

  // Custom checked exception to indicate insufficient balance
  static class InsufficientBalanceException extends Exception {
    private final double balance;
    private final double requested;

    public InsufficientBalanceException(double balance, double requested) {
      super("Insufficient balance: available=" + balance + ", requested=" + requested);
      this.balance = balance;
      this.requested = requested;
    }

    public double getBalance() {
      return balance;
    }

    public double getRequested() {
      return requested;
    }
  }

  public static void main(String[] args) {
    double balance = 5000.0;
    double withdrawalRequest = 8000.0;

    try {
      withdraw(balance, withdrawalRequest);
      System.out.println("Withdrawal successful");
    } catch (InsufficientBalanceException e) {
      // Handle the problem where requested amount exceeds available balance
      System.out.println("Cannot withdraw: " + e.getMessage());
    }
  }

  static void withdraw(double balance, double amount) throws InsufficientBalanceException {
    if (amount > balance) {
      throw new InsufficientBalanceException(balance, amount);
    }
    // otherwise proceed (not implemented as this is a scenario demo)
  }

}
