import java.util.Scanner;

public class returnAllCharacInAString {

  public static String[] returnAllCharacters(String text) {
    String[] characters = new String[text.length()];
    for (int i = 0; i < text.length(); i++) {
      characters[i] = String.valueOf(text.charAt(i));
    }
    return characters;
  }

  public static boolean compareStringArrays(String[] first, String[] second) {
    if (first == second) {
      return true;
    }
    if (first == null || second == null || first.length != second.length) {
      return false;
    }
    for (int i = 0; i < first.length; i++) {
      if (!first[i].equals(second[i])) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String text = scanner.next();

    String[] userDefinedResult = returnAllCharacters(text);
    char[] builtInChars = text.toCharArray();
    String[] builtInResult = new String[builtInChars.length];
    for (int i = 0; i < builtInChars.length; i++) {
      builtInResult[i] = String.valueOf(builtInChars[i]);
    }

    boolean result = compareStringArrays(userDefinedResult, builtInResult);
    System.out.println(result);
    scanner.close();
  }
}
