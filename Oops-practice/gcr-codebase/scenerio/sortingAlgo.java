package scenerio;

public class sortingAlgo {
  // Various sorting algorithm implementations (in-place where applicable)

  public static void bubbleSort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      boolean swapped = false;
      for (int j = 0; j < n - 1 - i; j++) {
        if (a[j] > a[j + 1]) {
          int t = a[j];
          a[j] = a[j + 1];
          a[j + 1] = t;
          swapped = true;
        }
      }
      if (!swapped)
        break;
    }
  }

  public static void selectionSort(int[] a) {
    int n = a.length;
    for (int i = 0; i < n - 1; i++) {
      int min = i;
      for (int j = i + 1; j < n; j++)
        if (a[j] < a[min])
          min = j;
      int t = a[i];
      a[i] = a[min];
      a[min] = t;
    }
  }

  public static void insertionSort(int[] a) {
    for (int i = 1; i < a.length; i++) {
      int key = a[i];
      int j = i - 1;
      while (j >= 0 && a[j] > key) {
        a[j + 1] = a[j];
        j--;
      }
      a[j + 1] = key;
    }
  }

  public static void mergeSort(int[] a) {
    if (a.length < 2)
      return;
    mergeSortRec(a, 0, a.length - 1);
  }

  private static void mergeSortRec(int[] a, int l, int r) {
    if (l >= r)
      return;
    int m = (l + r) >>> 1;
    mergeSortRec(a, l, m);
    mergeSortRec(a, m + 1, r);
    merge(a, l, m, r);
  }

  private static void merge(int[] a, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    System.arraycopy(a, l, L, 0, n1);
    System.arraycopy(a, m + 1, R, 0, n2);
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2)
      a[k++] = (L[i] <= R[j]) ? L[i++] : R[j++];
    while (i < n1)
      a[k++] = L[i++];
    while (j < n2)
      a[k++] = R[j++];
  }

  public static void quickSort(int[] a) {
    quickSortRec(a, 0, a.length - 1);
  }

  private static void quickSortRec(int[] a, int lo, int hi) {
    if (lo >= hi)
      return;
    int p = partition(a, lo, hi);
    quickSortRec(a, lo, p - 1);
    quickSortRec(a, p + 1, hi);
  }

  private static int partition(int[] a, int lo, int hi) {
    int pivot = a[hi];
    int i = lo;
    for (int j = lo; j < hi; j++) {
      if (a[j] <= pivot) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        i++;
      }
    }
    int t = a[i];
    a[i] = a[hi];
    a[hi] = t;
    return i;
  }

  public static void heapSort(int[] a) {
    int n = a.length;
    for (int i = n / 2 - 1; i >= 0; i--)
      heapify(a, n, i);
    for (int i = n - 1; i > 0; i--) {
      int t = a[0];
      a[0] = a[i];
      a[i] = t;
      heapify(a, i, 0);
    }
  }

  private static void heapify(int[] a, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;
    if (l < n && a[l] > a[largest])
      largest = l;
    if (r < n && a[r] > a[largest])
      largest = r;
    if (largest != i) {
      int t = a[i];
      a[i] = a[largest];
      a[largest] = t;
      heapify(a, n, largest);
    }
  }

  // Counting sort for non-negative integers
  public static int[] countingSort(int[] a) {
    if (a.length == 0)
      return a;
    int max = a[0];
    for (int v : a)
      if (v > max)
        max = v;
    int[] cnt = new int[max + 1];
    for (int v : a)
      cnt[v]++;
    int idx = 0;
    int[] out = new int[a.length];
    for (int i = 0; i < cnt.length; i++) {
      while (cnt[i]-- > 0)
        out[idx++] = i;
    }
    return out;
  }

  // Radix sort for non-negative integers (LSD base 10)
  public static void radixSort(int[] a) {
    if (a.length == 0)
      return;
    int max = a[0];
    for (int v : a)
      if (v > max)
        max = v;
    int exp = 1;
    int[] aux = new int[a.length];
    while (max / exp > 0) {
      int[] cnt = new int[10];
      for (int v : a)
        cnt[(v / exp) % 10]++;
      for (int i = 1; i < 10; i++)
        cnt[i] += cnt[i - 1];
      for (int i = a.length - 1; i >= 0; i--)
        aux[--cnt[(a[i] / exp) % 10]] = a[i];
      System.arraycopy(aux, 0, a, 0, a.length);
      exp *= 10;
    }
  }

  private static String toString(int[] a) {
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < a.length; i++) {
      if (i > 0)
        sb.append(',');
      sb.append(a[i]);
    }
    sb.append(']');
    return sb.toString();
  }

  public static void main(String[] args) {
    int[] original = { 5, 2, 9, 1, 5, 6, 0, 3 };
    int[] a;

    a = original.clone();
    bubbleSort(a);
    System.out.println("bubble: " + toString(a));
    a = original.clone();
    selectionSort(a);
    System.out.println("selection: " + toString(a));
    a = original.clone();
    insertionSort(a);
    System.out.println("insertion: " + toString(a));
    a = original.clone();
    mergeSort(a);
    System.out.println("merge: " + toString(a));
    a = original.clone();
    quickSort(a);
    System.out.println("quick: " + toString(a));
    a = original.clone();
    heapSort(a);
    System.out.println("heap: " + toString(a));
    int[] counted = countingSort(original.clone());
    System.out.println("counting: " + toString(counted));
    a = original.clone();
    radixSort(a);
    System.out.println("radix: " + toString(a));
  }
}
