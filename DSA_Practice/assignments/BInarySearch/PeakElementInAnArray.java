package DSA_Practice.assignments.BInarySearch;

public class PeakElementInAnArray {
  // Returns index of any peak element. Assumes non-empty array.
  public static int findPeak(int[] arr) {
    int n = arr.length;
    if (n == 0)
      return -1;
    if (n == 1)
      return 0;

    int left = 0, right = n - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;

      int leftVal = (mid - 1 >= 0) ? arr[mid - 1] : Integer.MIN_VALUE;
      int rightVal = (mid + 1 < n) ? arr[mid + 1] : Integer.MIN_VALUE;

      if (arr[mid] > leftVal && arr[mid] > rightVal) {
        return mid;
      }
      // If left neighbor is greater, a peak must exist on left side
      else if (mid - 1 >= 0 && arr[mid] < arr[mid - 1]) {
        right = mid - 1;
      } else { // otherwise go right
        left = mid + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] arr = { 1, 3, 20, 4, 1, 0 };
    int idx = findPeak(arr);
    if (idx >= 0)
      System.out.println("Peak at index: " + idx + ", value: " + arr[idx]);
    else
      System.out.println("No peak found");
  }
}
