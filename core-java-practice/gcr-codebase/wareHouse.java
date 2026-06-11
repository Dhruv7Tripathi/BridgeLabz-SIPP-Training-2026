import java.util.HashSet;
import java.util.Set;

public class wareHouse {

  public static int max(int[] stock) {
    if (stock == null || stock.length == 0) {
      throw new IllegalArgumentException("stock must not be empty");
    }
    int max = stock[0];
    for (int value : stock) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  public static int min(int[] stock) {
    if (stock == null || stock.length == 0) {
      throw new IllegalArgumentException("stock must not be empty");
    }
    int min = stock[0];
    for (int value : stock) {
      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  public static int totalStock(int[] stock) {
    if (stock == null) {
      throw new IllegalArgumentException("stock must not be null");
    }
    int total = 0;
    for (int value : stock) {
      total += value;
    }
    return total;
  }

  public static boolean hasDuplicates(int[] stock) {
    if (stock == null) {
      throw new IllegalArgumentException("stock must not be null");
    }
    Set<Integer> seen = new HashSet<>();
    for (int value : stock) {
      if (!seen.add(value)) {
        return true;
      }
    }
    return false;
  }

  public static int[] rotateStock(int[] stock, int k) {
    if (stock == null) {
      throw new IllegalArgumentException("stock must not be null");
    }
    if (stock.length == 0) {
      return new int[0];
    }

    int n = stock.length;
    k = ((k % n) + n) % n;
    int[] rotated = new int[n];
    for (int i = 0; i < n; i++) {
      rotated[(i + k) % n] = stock[i];
    }
    return rotated;
  }

  public static int[][] transposeShelfGrid(int[][] grid) {
    if (grid == null) {
      throw new IllegalArgumentException("grid must not be null");
    }
    if (grid.length == 0) {
      return new int[0][0];
    }

    int rows = grid.length;
    int cols = grid[0].length;
    int[][] transposed = new int[cols][rows];

    for (int i = 0; i < rows; i++) {
      if (grid[i].length != cols) {
        throw new IllegalArgumentException("grid must be rectangular");
      }
      for (int j = 0; j < cols; j++) {
        transposed[j][i] = grid[i][j];
      }
    }
    return transposed;
  }
  public static void main(String[] args) {
    int[] stock = { 10, 20, 30, 40, 50 };
    System.out.println("Max stock: " + max(stock));
    System.out.println("Min stock: " + min(stock));
    System.out.println("Total stock: " + totalStock(stock));
    System.out.println("Has duplicates: " + hasDuplicates(stock));

    int k = 2;
    int[] rotatedStock = rotateStock(stock, k);
    System.out.print("Rotated stock by " + k + ": ");
    for (int value : rotatedStock) {
      System.out.print(value + " ");
    }
    System.out.println();

    int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
    int[][] transposedGrid = transposeShelfGrid(grid);
    System.out.println("Transposed grid:");
    for (int i = 0; i < transposedGrid.length; i++) {
      for (int j = 0; j < transposedGrid[i].length; j++) {
        System.out.print(transposedGrid[i][j] + " ");
      }
      System.out.println();
    }
}
