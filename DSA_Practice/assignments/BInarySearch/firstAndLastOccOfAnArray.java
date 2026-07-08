package DSA_Practice.assignments.BInarySearch;

public class firstAndLastOccOfAnArray {
  // Returns an array of two integers: {firstIndex, lastIndex}
  // If target not found, returns {-1, -1}
  public static int[] findFirstAndLast(int[] nums, int target) {
    int first = findBound(nums, target, true);
    int last = findBound(nums, target, false);
    return new int[] { first, last };
  }

  // helper: if findFirst is true, find first occurrence, else find last
  // occurrence
  private static int findBound(int[] nums, int target, boolean findFirst) {
    int left = 0, right = nums.length - 1;
    int result = -1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        result = mid;
        if (findFirst) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return result;
  }

  // simple demo main
  public static void main(String[] args) {
    int[] nums = { 1, 2, 2, 2, 3, 4, 5 };
    int target = 2;
    int[] ans = findFirstAndLast(nums, target);
    System.out.println(ans[0] + " " + ans[1]);
  }
}
