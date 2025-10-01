package Selectionsort;

public class SelectionSort {

    public static void sort(int[] arr, Selectionsort.Metrics m) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            int minVal = arr[i];   // ✅ cache current min value
            for (int j = i + 1; j < n; j++) {
                m.comparisons++;
                int v = arr[j];    // ✅ read arr[j] only once
                if (v < minVal) {  // compare with cached value
                    minVal = v;    // update cached min
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
                m.swaps++;
            }
        }
        m.timeNs = System.nanoTime() - start;
    }

}
