import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class dailyExpenseLogger {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    File file = new File("expenses.txt");

    System.out.println("Daily Expense Logger");
    System.out.println("Enter expenses. To stop, leave category blank and press Enter.");

    while (true) {
      System.out.print("Category: ");
      String category = sc.nextLine().trim();
      if (category.isEmpty())
        break;

      System.out.print("Amount: ");
      String amount = sc.nextLine().trim();

      String entry = category + " - " + amount;

      try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
        bw.write(entry);
        bw.newLine();
      } catch (IOException e) {
        System.err.println("Failed to write to expenses.txt: " + e.getMessage());
      }
    }

    System.out.println("Done. Entries appended to expenses.txt");
    sc.close();
  }
}
