
public class wizard {
  private int value = 42;

  public void demonstrateScope() {
    int value = 7; // local shadows instance variable
    System.out.println("local value = " + value);
    System.out.println("instance value = " + this.value);
  }

  public static boolean isPrime(int n) {
    if (n <= 1)
      return false;
    if (n <= 3)
      return true;
    if (n % 2 == 0 || n % 3 == 0)
      return false;
    for (int i = 5; i * i <= n; i += 6) {
      if (n % i == 0)
        return false;
    }
    return true;
  }

  // Iterative factorial for int input
  public static long factorial(int n) {
    if (n < 0)
      throw new IllegalArgumentException("n must be >= 0");
    long res = 1;
    for (int i = 2; i <= n; i++)
      res *= i;
    return res;
  }

  public static double factorial(double n) {
    // if (Double.isNaN(n) || Double.isInfinite(n))
    // throw new IllegalArgumentException("invalid n");
    int m = (int) Math.floor(n);
    if (m < 0)
      System.out.println("n must be >= 0");
    double res = 1.0;
    for (int i = 2; i <= m; i++)
      res *= i;
    return res;
  }

  public static long fibonacci(int n) {
    if (n < 0)
      System.out.println("n must be >= 0");
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    long a = 0, b = 1;
    for (int i = 2; i <= n; i++) {
      long t = a + b;
      a = b;
      b = t;
    }
    return b;
  }

  public static long gcd(long a, long b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      long t = a % b;
      a = b;
      b = t;
    }
    return a;
  }

  public static long lcm(long a, long b) {
    if (a == 0 || b == 0)
      return 0;
    return Math.abs(a / gcd(a, b) * b);
  }

  public static double power(double base, int exp) {
    if (exp == 0)
      return 1.0;
    double res = 1.0;
    int e = Math.abs(exp);
    for (int i = 0; i < e; i++)
      res *= base;
    return exp < 0 ? 1.0 / res : res;
  }

  public static void main(String[] args) {
    wizard w = new wizard();
    System.out.println("isPrime(17)=" + isPrime(17));
    System.out.println("factorial(6)=" + factorial(6));
    System.out.println("factorial(5.7)=" + factorial(5.7));
    System.out.println("fibonacci(10)=" + fibonacci(10));
    System.out.println("gcd(48,18)=" + gcd(48, 18));
    System.out.println("lcm(12,15)=" + lcm(12, 15));
    System.out.println("power(2,10)=" + power(2, 10));
    w.demonstrateScope();
  }
}
