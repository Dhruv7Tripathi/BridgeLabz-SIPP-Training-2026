import java.util.InputMismatchException;
import java.util.Scanner;

public class uncheckedException {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try {
      System.out.print("Enter numerator: ");
      double a = sc.nextDouble();
      System.out.print("Enter denominator: ");
      double b = sc.nextDouble();
      double result = a / b; // may throw ArithmeticException for integer divide by zero, but for double it's
                             // Infinity
      if (Double.isInfinite(result) || Double.isNaN(result)) {
        throw new ArithmeticException("Division by zero");
      }
      System.out.println("Result: " + result);
    } catch (InputMismatchException ime) {
      System.out.println("InputMismatchException: Please enter numeric values.");
    } catch (ArithmeticException ae) {
      System.out.println("ArithmeticException: " + ae.getMessage());
    } finally {
      sc.close();
    }
  }
}
