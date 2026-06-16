import java.util.Scanner;

public class compareTwoString {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter first string: ");
    String first = scanner.next();

    System.out.print("Enter second string: ");
    String second = scanner.next();

    boolean charAtResult = compareUsingCharAt(first, second);
    boolean equalsResult = first.equals(second);

    System.out.println("Result using charAt(): " + charAtResult);
    System.out.println("Result using equals(): " + equalsResult);
    System.out.println("Both results are same: " + (charAtResult == equalsResult));

    scanner.close();
  }

  private static boolean compareUsingCharAt(String first, String second) {
    if (first.length() != second.length()) {
      return false;
    }

    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) {
        return false;
      }
    }

    return true;
  }
}
