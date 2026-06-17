public class multipleCatchBlock {

  public static void main(String[] args) {
    // Test case 1: Valid array and index
    int[] arr = { 10, 20, 30, 40, 50 };
    retrieveValue(arr, 2);

    // Test case 2: Index out of bounds
    retrieveValue(arr, 10);

    // Test case 3: Null array
    retrieveValue(null, 0);
  }

  public static void retrieveValue(int[] array, int index) {
    try {
      int value = array[index];
      System.out.println("Value at index " + index + ": " + value);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Invalid index!");
    } catch (NullPointerException e) {
      System.out.println("Array is not initialized!");
    }
  }
}
