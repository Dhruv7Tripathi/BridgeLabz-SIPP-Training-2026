package DSA_Practice.assignments.BInarySearch;

public class RotationPointInARotatedArray {
  public static int findRotationPointIndex(int[] arr) {
    if (arr == null || arr.length == 0)
      return -1;
    int left = 0, right = arr.length - 1;

    while (left < right) {
      int mid = left + (right - left) / 2;
      if (arr[mid] > arr[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }

  public static void main(String[] args) {
    int[] a = { 15, 18, 2, 3, 6, 12 };
    System.out.println(findRotationPointIndex(a)); // expected 2
  }
}
