import java.util.Scanner;

public class maxHandShake {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    if (!sc.hasNextInt())
      return;
    int numberOfStudents = sc.nextInt();
    sc.close();
    System.out.println(maxHandshakes(numberOfStudents));
  }

  public static long maxHandshakes(int n) {
    if (n <= 1)
      return 0L;
    return (long) n * (n - 1) / 2;
  }
}
