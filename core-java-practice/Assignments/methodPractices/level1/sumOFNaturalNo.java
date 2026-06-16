import java.util.Scanner;

public class sumOFNaturalNo {

  public static int sumOfNaturalNumbers(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
      sum += i;
    }
    return sum;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a natural number: ");
    int n = scanner.nextInt();

    int result = sumOfNaturalNumbers(n);

    System.out.println("Sum of first " + n + " natural numbers: " + result);

    scanner.close();
  }
}
