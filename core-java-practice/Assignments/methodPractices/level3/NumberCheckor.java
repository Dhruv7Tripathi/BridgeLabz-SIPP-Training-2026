public class NumberCheckor {

  public static void main(String[] args) {
    int number = 153;
    int[] digits = storeDigits(number);

    System.out.println("Number: " + number);
    System.out.println("Digit count: " + countDigits(number));
    System.out.print("Digits: ");
    printDigits(digits);
    System.out.println("Duck number: " + isDuckNumber(digits));
    System.out.println("Armstrong number: " + isArmstrongNumber(digits));

    int[] largest = findLargestAndSecondLargest(digits);
    System.out.println("Largest: " + largest[0]);
    System.out.println("Second largest: " + largest[1]);

    int[] smallest = findSmallestAndSecondSmallest(digits);
    System.out.println("Smallest: " + smallest[0]);
    System.out.println("Second smallest: " + smallest[1]);
  }

  public static int countDigits(int number) {
    number = Math.abs(number);
    if (number == 0) {
      return 1;
    }

    int count = 0;
    while (number > 0) {
      count++;
      number /= 10;
    }
    return count;
  }

  public static int[] storeDigits(int number) {
    number = Math.abs(number);
    int[] digits = new int[countDigits(number)];

    if (number == 0) {
      digits[0] = 0;
      return digits;
    }

    for (int i = digits.length - 1; i >= 0; i--) {
      digits[i] = number % 10;
      number /= 10;
    }
    return digits;
  }

  public static boolean isDuckNumber(int[] digits) {
    for (int digit : digits) {
      if (digit == 0) {
        return true;
      }
    }
    return false;
  }

  public static boolean isArmstrongNumber(int[] digits) {
    int power = digits.length;
    int sum = 0;
    int original = 0;

    for (int digit : digits) {
      sum += (int) Math.pow(digit, power);
      original = original * 10 + digit;
    }

    return sum == original;
  }

  public static int[] findLargestAndSecondLargest(int[] digits) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int digit : digits) {
      if (digit > largest) {
        secondLargest = largest;
        largest = digit;
      } else if (digit > secondLargest && digit < largest) {
        secondLargest = digit;
      }
    }

    return new int[] { largest, secondLargest };
  }

  public static int[] findSmallestAndSecondSmallest(int[] digits) {
    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;

    for (int digit : digits) {
      if (digit < smallest) {
        secondSmallest = smallest;
        smallest = digit;
      } else if (digit < secondSmallest && digit > smallest) {
        secondSmallest = digit;
      }
    }

    return new int[] { smallest, secondSmallest };
  }

  private static void printDigits(int[] digits) {
    for (int i = 0; i < digits.length; i++) {
      System.out.print(digits[i]);
      if (i < digits.length - 1) {
        System.out.print(", ");
      }
    }
    System.out.println();
  }
}
