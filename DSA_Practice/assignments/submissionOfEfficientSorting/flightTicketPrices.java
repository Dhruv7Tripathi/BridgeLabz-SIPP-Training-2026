package DSA_Practice.assignments.submissionOfEfficientSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class flightTicketPrices {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String line = br.readLine();
    if (line == null || line.trim().isEmpty())
      return;
    int n = Integer.parseInt(line.trim());
    int[] prices = new int[n];
    String[] parts = br.readLine().trim().split("\\s+");
    for (int i = 0; i < n; i++)
      prices[i] = Integer.parseInt(parts[i]);
    quickSort(prices, 0, n - 1);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) {
      if (i > 0)
        sb.append(' ');
      sb.append(prices[i]);
    }
    System.out.println(sb.toString());
  }

  static final Random rand = new Random();

  static void quickSort(int[] a, int low, int high) {
    if (low >= high)
      return;
    int p = partition(a, low, high);
    quickSort(a, low, p - 1);
    quickSort(a, p + 1, high);
  }

  static int partition(int[] a, int low, int high) {
    int pivotIndex = low + rand.nextInt(high - low + 1);
    int pivot = a[pivotIndex];
    swap(a, pivotIndex, high);
    int store = low;
    for (int i = low; i < high; i++) {
      if (a[i] <= pivot) {
        swap(a, i, store);
        store++;
      }
    }
    swap(a, store, high);
    return store;
  }

  static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }

}
