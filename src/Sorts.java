import java.util.Arrays;
import java.util.Random;

/**
 * Created by svetlana on 14/09/14.
 */
public class Sorts {

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(100);
        }
        System.out.println("a before sort: " + Arrays.toString(a));

        insertionSort(a);
        System.out.println("a after sort: " + Arrays.toString(a));
    }

    private static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i ++) {
            for (int j = a.length -1; j > i; j--) {
                if (a[j] < a[i]) {
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        int j;
        for (int i = 1; i < a.length; i++) {
            j = i;
            int newValue = a[i];
            while (j > 0 && a[j - 1] > newValue) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = newValue;
        }
    }

    private static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int start, int end) {
        if (end <= start) {
            return;
        }
        if (end - start + 1 == 2) {
            if (a[end] < a[start]) {
                swap(a, start, end);
            }
            return;
        }
        int i = start;
        int j = end;
        int m = a[ start + (end - start)/2];

        while (i < j) {
            while (a[i] < m) {
                i++;
            }
            while (a[j] > m) {
                j--;
            }
            if (i < j) {
                swap(a, i, j);
            }
        }

        if (i < end) {
            quickSort(a, i + 1, end);
        }

        if (j > start) {
            quickSort(a, start, j - 1);
        }

    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
