import java.util.Scanner;

public class leapYearOrNot {

  public static boolean isLeapYear(int year) {
    // Check if year is in Gregorian calendar (>= 1582)
    if (year < 1582) {
      return false;
    }

    // Leap year is divisible by 4 and not divisible by 100 or divisible by 400
    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
      return true;
    }

    return false;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a year: ");
    int year = scanner.nextInt();

    if (isLeapYear(year)) {
      System.out.println(year + " is a Leap Year");
    } else {
      System.out.println(year + " is not a Leap Year");
    }

    scanner.close();
  }
}
