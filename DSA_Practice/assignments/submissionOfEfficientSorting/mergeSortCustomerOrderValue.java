package DSA_Practice.assignments.submissionOfEfficientSorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class mergeSortCustomerOrderValue {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String line = br.readLine();
    if (line == null || line.trim().isEmpty()) {
      return;
    }

    int n = Integer.parseInt(line.trim());
    List<Long> values = new ArrayList<>(n);

    while (values.size() < n && (line = br.readLine()) != null) {
      line = line.replace('[', ' ').replace(']', ' ');
      StringTokenizer st = new StringTokenizer(line);
      while (st.hasMoreTokens() && values.size() < n) {
        values.add(Long.parseLong(st.nextToken()));
      }
    }

    long[] arr = new long[n];
    for (int i = 0; i < n; i++) {
      arr[i] = values.get(i);
    }

    long[] temp = new long[n];
    mergeSort(arr, 0, n - 1, temp);

    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < n; i++) {
      if (i > 0)
        sb.append(' ');
      sb.append(arr[i]);
    }
    sb.append(']');
    System.out.println(sb.toString());
  }

  private static void mergeSort(long[] arr, int left, int right, long[] temp) {
    if (left >= right) {
      return;
    }

    int mid = left + (right - left) / 2;
    mergeSort(arr, left, mid, temp);
    mergeSort(arr, mid + 1, right, temp);
    merge(arr, left, mid, right, temp);
  }

  private static void merge(long[] arr, int left, int mid, int right, long[] temp) {
    int i = left;
    int j = mid + 1;
    int k = left;

    while (i <= mid && j <= right) {
      if (arr[i] <= arr[j]) {
        temp[k++] = arr[i++];
      } else {
        temp[k++] = arr[j++];
      }
    }

    while (i <= mid) {
      temp[k++] = arr[i++];
    }

    while (j <= right) {
      temp[k++] = arr[j++];
    }

    for (int idx = left; idx <= right; idx++) {
      arr[idx] = temp[idx];
    }
  }
}
