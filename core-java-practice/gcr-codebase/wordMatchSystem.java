import java.util.*;

public class wordMatchSystem {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = "", s2 = "";
    if (sc.hasNextLine())
      s1 = sc.nextLine();
    if (sc.hasNextLine())
      s2 = sc.nextLine();
    sc.close();

    String s1Trim = s1 == null ? "" : s1.trim();
    String s2Trim = s2 == null ? "" : s2.trim();

    // Display both strings in uppercase
    System.out.println(s1Trim.toUpperCase());
    System.out.println(s2Trim.toUpperCase());

    // Show total length of each string
    System.out.println(s1Trim.length());
    System.out.println(s2Trim.length());

    // Check anagram (case-insensitive, ignore spaces)
    if (isAnagram(s1Trim, s2Trim)) {
      System.out.println("The two strings are anagrams.");
    } else {
      System.out.println("The two strings are not anagrams.");
    }
  }

  private static boolean isAnagram(String a, String b) {

    char[] a1 = a.toCharArray();
    char[] b1 = b.toCharArray();

    Arrays.sort(a1);
    Arrays.sort(b1);

    if (Arrays.equals(a1, b1)) {
      System.out.println("Anagram");
    } else {
      System.out.println("Not Anagram");
    }
    return Arrays.equals(a1, b1);
  }
}
