import java.util.Scanner;

public class sumNNaturalNo {

  public static long sumRecursive(long n) {
    if (n <= 0) {
      return 0;
    }
    return n + sumRecursive(n - 1);
  }

  public static long sumFormula(long n) {
    return n * (n + 1) / 2;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a natural number: ");
    long number = scanner.nextLong();

    if (number <= 0) {
      System.out.println("Error: Please enter a valid natural number (positive integer).");
      scanner.close();
      return;
    }

    long recursiveSum = sumRecursive(number);
    long formulaSum = sumFormula(number);

    System.out.println("\nResults for n = " + number + ":");
    System.out.println("Sum using Recursion: " + recursiveSum);
    System.out.println("Sum using Formula n*(n+1)/2: " + formulaSum);

    if (recursiveSum == formulaSum) {
      System.out.println("\n✓ Both computations are CORRECT and match!");
    } else {
      System.out.println("\n✗ Results do not match!");
    }

    scanner.close();
  }
}
