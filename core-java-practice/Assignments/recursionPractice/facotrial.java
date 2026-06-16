import java.util.*;

public class facotrial {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    if (!sc.hasNextLong())
      return;
    long n = sc.nextLong();
    System.out.println(factorial(n));
  }

  private static long factorial(long n) {
    if (n <= 1)
      return 1;
    return n * factorial(n - 1);
  }
}
