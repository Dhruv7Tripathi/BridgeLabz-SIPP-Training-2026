import java.util.Scanner;

public class smallestAndLargestThreeNo {

  public static int[] findSmallestAndLargest(int number1, int number2, int number3) {
    int smallest = Math.min(Math.min(number1, number2), number3);
    int largest = Math.max(Math.max(number1, number2), number3);
    return new int[] { smallest, largest };
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter first number:");
    int num1 = scanner.nextInt();

    System.out.println("Enter second number:");
    int num2 = scanner.nextInt();

    System.out.println("Enter third number:");
    int num3 = scanner.nextInt();

    int[] result = findSmallestAndLargest(num1, num2, num3);

    System.out.println("Smallest: " + result[0]);
    System.out.println("Largest: " + result[1]);

    scanner.close();
  }
}
