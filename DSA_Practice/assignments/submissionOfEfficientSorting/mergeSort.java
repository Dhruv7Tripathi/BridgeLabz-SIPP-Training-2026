package DSA_Practice.assignments.submissionOfEfficientSorting;

public class mergeSort {
  public static void main(String[] args) throws Exception {
		java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String line;
		// Read all input
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			if (line.trim().isEmpty()) continue;
			sb.append(line.trim()).append(' ');
		}
		String all = sb.toString().trim();
		if (all.isEmpty()) return;
		java.util.List<String> parts = new java.util.ArrayList<>();
		for (String s : all.split("\\s+")) parts.add(s);

		int idx = 0;
		int n = 0;
		try {
			n = Integer.parseInt(parts.get(0).replaceAll("[^0-9-]", ""));
			idx = 1;
		} catch (Exception e) {
			// if first token is not a plain number, try to find number in string
			String t = parts.get(0).replaceAll("[^0-9-]", "");
			if (!t.isEmpty()) {
				n = Integer.parseInt(t);
				idx = 1;
			}
		}

		java.util.ArrayList<Integer> vals = new java.util.ArrayList<>();
		for (int i = idx; i < parts.size(); i++) {
			String token = parts.get(i).replaceAll("[\[\],]", "");
			token = token.replaceAll("[^0-9-]", "");
			if (token.isEmpty()) continue;
			try {
				vals.add(Integer.parseInt(token));
			} catch (Exception ex) {
				// ignore
			}
		}

		if (n == 0) n = vals.size();
		int[] arr = new int[n];
		for (int i = 0; i < n && i < vals.size(); i++) arr[i] = vals.get(i);

		mergeSort(arr, 0, n - 1);

		// print in required format
		StringBuilder out = new StringBuilder();
		out.append('[');
		for (int i = 0; i < n; i++) {
			out.append(arr[i]);
			if (i != n - 1) out.append(' ');
		}
		out.append(']');
		System.out.println(out.toString());
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
