package Selectionsort;

import java.util.Random;

public class SelectionSortTest {

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i-1] > a[i]) return false;
        return true;
    }

    public static void testEmpty() {
        int[] a = {};
        Selectionsort.Metrics m = new Selectionsort.Metrics();
        SelectionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void testSingle() {
        int[] a = {7};
        Selectionsort.Metrics m = new Selectionsort.Metrics();
        SelectionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void testDuplicates() {
        int[] a = {3,3,3,2,2,1,1,1};
        Selectionsort.Metrics m = new Selectionsort.Metrics();
        SelectionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void testSorted() {
        int[] a = {1,2,3,4,5,6};
        Selectionsort.Metrics m = new Selectionsort.Metrics();
        SelectionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void testReverse() {
        int[] a = {6,5,4,3,2,1};
        Selectionsort.Metrics m = new Selectionsort.Metrics();
        SelectionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void testRandom() {
        Random rnd = new Random(13);
        int[] a = new int[1000];
        for (int i = 0; i < a.length; i++) a[i] = rnd.nextInt(1_000_000);
        Selectionsort.Metrics m = new Selectionsort.Metrics();
        SelectionSort.sort(a, m);
        assert isSorted(a);
    }

    public static void main(String[] args) {
        testEmpty();
        testSingle();
        testDuplicates();
        testSorted();
        testReverse();
        testRandom();
        System.out.println("SelectionSort: ALL TESTS PASSED");
    }
}
