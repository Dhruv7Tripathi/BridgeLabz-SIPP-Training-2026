import java.util.*;

class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();

    int result = maximum69Number(num);
    System.out.println(result); // Output: 9969
  }

  public static int maximum69Number(int num) {

    int temp = num;
    int pos = 0;
    int p = 1;
    while (temp > 0) {
      int d = temp % 10;
      if (d == 6) {
        pos = p;
      }
      p *= 10;
      temp /= 10;
    }
    return num + 3 * pos;
  }
}
