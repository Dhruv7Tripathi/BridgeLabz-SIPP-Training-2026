import java.util.Scanner;

public class sumAndProductFactor {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();

    int[] factors = findFactors(number);

    for (int factor : factors) {
      System.out.println(factor);
    }

    System.out.println("Sum = " + sumOfFactors(factors));
    System.out.println("Sum of squares = " + sumOfSquareOfFactors(factors));
    System.out.println("Product = " + productOfFactors(factors));

    scanner.close();
  }

  public static int[] findFactors(int number) {
    int count = 0;

    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        count++;
      }
    }

    int[] factors = new int[count];
    int index = 0;

    for (int i = 1; i <= number; i++) {
      if (number % i == 0) {
        factors[index++] = i;
      }
    }

    return factors;
  }

  public static int sumOfFactors(int[] factors) {
    int sum = 0;
    for (int factor : factors) {
      sum += factor;
    }
    return sum;
  }

  public static long productOfFactors(int[] factors) {
    long product = 1;
    for (int factor : factors) {
      product *= factor;
    }
    return product;
  }

  public static double sumOfSquareOfFactors(int[] factors) {
    double sum = 0;
    for (int factor : factors) {
      sum += Math.pow(factor, 2);
    }
    return sum;
  }
}
