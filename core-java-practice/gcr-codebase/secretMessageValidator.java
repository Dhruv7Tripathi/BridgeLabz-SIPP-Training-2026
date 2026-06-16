import java.util.Scanner;

public class secretMessageValidator {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the secret code: ");
    String code = scanner.nextLine();

    validateAndReport(code);

    scanner.close();
  }

  public static void validateAndReport(String code) {
    int vowels = 0;
    int consonants = 0;
    int digits = 0;
    int specialChars = 0;

    // Count each character type
    for (char c : code.toCharArray()) {
      if (Character.isLetter(c)) {
        char lower = Character.toLowerCase(c);
        if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
          vowels++;
        } else {
          consonants++;
        }
      } else if (Character.isDigit(c)) {
        digits++;
      } else {
        specialChars++;
      }
    }

    // Check if code is Strong or Weak
    boolean isStrong = digits >= 2 && specialChars >= 1 && code.length() >= 8;
    String strength = isStrong ? "Strong" : "Weak";

    System.out.println("Code: " + code);
    System.out.println("Length: " + code.length());
    System.out.println("\nCharacter Analysis:");
    System.out.println("  Vowels: " + vowels);
    System.out.println("  Consonants: " + consonants);
    System.out.println("  Digits: " + digits);
    System.out.println("  Special Characters: " + specialChars);
    System.out.println("\nStrength Validation:");
    System.out.println("  Minimum length (8): " + (code.length() >= 8 ? "✓ Pass" : "✗ Fail"));
    System.out.println("  At least 2 digits: " + (digits >= 2 ? "✓ Pass" : "✗ Fail"));
    System.out.println("  At least 1 special character: " + (specialChars >= 1 ? "✓ Pass" : "✗ Fail"));
    System.out.println("\nOverall Strength: " + strength);
  }
}
