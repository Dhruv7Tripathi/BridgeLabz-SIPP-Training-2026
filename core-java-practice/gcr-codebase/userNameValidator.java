import java.util.Scanner;

public class userNameValidator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter username: ");
    String username = scanner.nextLine();

    boolean containsSpaces = username.contains(" ");
    int totalCharacters = username.length();
    String upperCaseUsername = username.toUpperCase();

    String normalized = username.replaceAll("\\s+", "").toLowerCase();
    String reversed = new StringBuilder(normalized).reverse().toString();
    boolean isPalindrome = normalized.equals(reversed);

    System.out.println("Contains spaces: " + (containsSpaces ? "Yes" : "No"));
    System.out.println("Total characters: " + totalCharacters);
    System.out.println("Uppercase username: " + upperCaseUsername);
    System.out.println("Palindrome: " + (isPalindrome ? "Yes" : "No"));

    scanner.close();
  }
}
