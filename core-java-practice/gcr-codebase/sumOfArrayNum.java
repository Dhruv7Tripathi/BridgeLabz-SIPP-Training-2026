public class sumOfArrayNum {

  public static int sum(int[] arr, int index) {
    if (arr == null || arr.length == 0) {
      return 0;
    }
    if (index == 0) {
      return arr[0];
    }
    return arr[index] + sum(arr, index - 1);
  }

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5 };
    System.out.println("Sum of array numbers: " + sum(arr, arr.length - 1));
  }
}
