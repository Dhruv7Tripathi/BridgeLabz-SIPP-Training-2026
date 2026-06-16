import java.util.Scanner;

public class createSubstringAndCompare {

  public static String createSubstringUsingCharAt(String text, int start, int end) {
    StringBuilder substring = new StringBuilder();
    for (int i = start; i < end && i < text.length(); i++) {
      substring.append(text.charAt(i));
    }
    return substring.toString();
  }

  public static boolean compareStringsUsingCharAt(String first, String second) {
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

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String text = scanner.next();
    int start = scanner.nextInt();
    int end = scanner.nextInt();

    String substringUsingCharAt = createSubstringUsingCharAt(text, start, end);
    String substringUsingBuiltIn = text.substring(start, end);
    boolean comparisonResult = compareStringsUsingCharAt(substringUsingCharAt, substringUsingBuiltIn);

    System.out.println(substringUsingCharAt);
    System.out.println(substringUsingBuiltIn);
    System.out.println(comparisonResult);

    scanner.close();
  }
}
