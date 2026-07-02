
public class genericsMethod {

  // Generic method to print any type of array
  public static <T> void printArray(T[] array) {
    for (T element : array) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  // Generic method to find maximum element
  public static <T extends Comparable<T>> T findMax(T[] array) {
    if (array == null || array.length == 0) {
      return null;
    }
    T max = array[0];
    for (T element : array) {
      if (element.compareTo(max) > 0) {
        max = element;
      }
    }
    return max;
  }

  // Generic method to check if array contains element
  public static <T> boolean contains(T[] array, T element) {
    for (T item : array) {
      if (item.equals(element)) {
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    Integer[] intArray = { 1, 2, 3, 4, 5 };
    String[] strArray = { "Hello", "World", "Java" };
    Double[] doubleArray = { 1.5, 2.7, 3.2, 1.1 };

    System.out.println("Integer Array:");
    printArray(intArray);

    System.out.println("String Array:");
    printArray(strArray);

    System.out.println("Double Array:");
    printArray(doubleArray);

    System.out.println("Max Integer: " + findMax(intArray));
    System.out.println("Max String: " + findMax(strArray));
    System.out.println("Max Double: " + findMax(doubleArray));

    System.out.println("Contains 3 in intArray: " + contains(intArray, 3));
    System.out.println("Contains 'Java' in strArray: " + contains(strArray, "Java"));
  }
}
