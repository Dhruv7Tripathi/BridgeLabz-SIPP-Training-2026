public class tax {
  public static void main(String[] args) {
    // sample incomes for 10 citizens
    double[] incomes = { 5000, 12000, 30000, 75000, 9500, 15000, 48000, 51000, 200000, 25000 };
    double totalTax = 0.0;

    for (int i = 0; i < incomes.length; i++) {
      double income = incomes[i];
      double taxRate;
      String bracket;

      if (income < 10000) {
        taxRate = 0.05;
        bracket = "<10K";
      } else if (income <= 50000) {
        taxRate = 0.15;
        bracket = "10K-50K";
      } else {
        taxRate = 0.30;
        bracket = ">50K";
      }

      double taxAmount = income * taxRate;
      totalTax += taxAmount;

      System.out.println("Citizen " + (i + 1) + ": Income=" + income + ", Bracket=" + bracket + ", Rate="
          + (taxRate * 100) + "%, Tax=" + taxAmount);
    }

    System.out.println("Total tax collected: " + totalTax);
  }
}
