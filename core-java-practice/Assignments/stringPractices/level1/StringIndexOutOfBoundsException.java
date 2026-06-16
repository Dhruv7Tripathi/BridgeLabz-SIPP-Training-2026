import java.util.Scanner;

public class StringIndexOutOfBoundsException {

  public static void generateException(String input) {
    System.out.println(input.charAt(input.length()));
  }

  public static void handleException(String input) {
    try {
      System.out.println(input.charAt(input.length()));
    } catch (java.lang.StringIndexOutOfBoundsException e) {
      System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();

    try {
      generateException(input);
    } catch (java.lang.StringIndexOutOfBoundsException e) {
      System.out.println("Generated exception: " + e.getMessage());
    }

    handleException(input);
    scanner.close();
  }
}
