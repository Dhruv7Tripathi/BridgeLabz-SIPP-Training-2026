public class sortestTallestMeanHeight {

  public static void main(String[] args) {
    int[] heights = new int[11];

    for (int i = 0; i < heights.length; i++) {
      heights[i] = 150 + (int) (Math.random() * 101);
    }

    int sum = findSum(heights);
    int mean = findMeanHeight(heights);
    int shortest = findShortestHeight(heights);
    int tallest = findTallestHeight(heights);

    System.out.println("Player heights in cm:");
    for (int height : heights) {
      System.out.print(height + " ");
    }
    System.out.println();
    System.out.println("Sum of heights: " + sum);
    System.out.println("Mean height: " + mean);
    System.out.println("Shortest height: " + shortest);
    System.out.println("Tallest height: " + tallest);
  }

  public static int findSum(int[] heights) {
    int sum = 0;
    for (int height : heights) {
      sum += height;
    }
    return sum;
  }

  public static int findMeanHeight(int[] heights) {
    return findSum(heights) / heights.length;
  }

  public static int findShortestHeight(int[] heights) {
    int shortest = heights[0];
    for (int height : heights) {
      if (height < shortest) {
        shortest = height;
      }
    }
    return shortest;
  }

  public static int findTallestHeight(int[] heights) {
    int tallest = heights[0];
    for (int height : heights) {
      if (height > tallest) {
        tallest = height;
      }
    }
    return tallest;
  }
}
