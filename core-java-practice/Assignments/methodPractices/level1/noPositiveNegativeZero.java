public class noPositiveNegativeZero {

  public static int checkNumber(int number) {
    if (number < 0) {
      return -1;
    } else if (number > 0) {
      return 1;
    }
    return 0;
  }

  public static void main(String[] args) {
    java.util.Scanner scanner = new java.util.Scanner(System.in);
    int number = scanner.nextInt();
    System.out.println(checkNumber(number));
    scanner.close();
  }
}
