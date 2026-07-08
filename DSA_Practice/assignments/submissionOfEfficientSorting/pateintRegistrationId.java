package DSA_Practice.assignments.submissionOfEfficientSorting;

import java.util.*;

public class pateintRegistrationId {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    if (!sc.hasNextInt())
      return;
    int n = sc.nextInt();
    List<Integer> list = new ArrayList<>();
    // read remaining tokens and extract integers
    while (sc.hasNext()) {
      String tok = sc.next();
      tok = tok.replaceAll("[^0-9-]", " ");
      String[] parts = tok.trim().split("\\s+");
      for (String p : parts) {
        if (p.length() == 0)
          continue;
        try {
          list.add(Integer.parseInt(p));
        } catch (NumberFormatException e) {
        }
      }
      if (list.size() >= n)
        break;
    }
    sc.close();
    int[] a = new int[Math.min(n, list.size())];
    for (int i = 0; i < a.length; i++)
      a[i] = list.get(i);
    mergeSort(a, 0, a.length - 1);
    // print in required format
    StringBuilder sb = new StringBuilder();
    sb.append('[');
    for (int i = 0; i < a.length; i++) {
      if (i > 0)
        sb.append(' ');
      sb.append(a[i]);
    }
    sb.append(']');
    System.out.print(sb.toString());
  }

  private static void mergeSort(int[] a, int l, int r) {
    if (l >= r)
      return;
    int m = l + (r - l) / 2;
    mergeSort(a, l, m);
    mergeSort(a, m + 1, r);
    merge(a, l, m, r);
  }

  private static void merge(int[] a, int l, int m, int r) {
    int n1 = m - l + 1;
    int n2 = r - m;
    int[] L = new int[n1];
    int[] R = new int[n2];
    for (int i = 0; i < n1; i++)
      L[i] = a[l + i];
    for (int j = 0; j < n2; j++)
      R[j] = a[m + 1 + j];
    int i = 0, j = 0, k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j])
        a[k++] = L[i++];
      else
        a[k++] = R[j++];
    }
    while (i < n1)
      a[k++] = L[i++];
    while (j < n2)
      a[k++] = R[j++];
  }
}
