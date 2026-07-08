package DSA_Practice.assignments.BInarySearch;

public class SearchTargetValueTwoDArray {
  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return false;
    int rows = matrix.length;
    int cols = matrix[0].length;
    int left = 0, right = rows * cols - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int r = mid / cols;
      int c = mid % cols;
      int val = matrix[r][c];
      if (val == target)
        return true;
      if (target < val)
        right = mid - 1;
      else
        left = mid + 1;
    }
    return false;
  }

  // simple main for quick manual testing
  public static void main(String[] args) {
    int[][] mat = {
        { 1, 3, 5, 7 },
        { 10, 11, 16, 20 },
        { 23, 30, 34, 50 }
    };
    System.out.println(searchMatrix(mat, 3)); // true
    System.out.println(searchMatrix(mat, 13)); // false
  }
}
