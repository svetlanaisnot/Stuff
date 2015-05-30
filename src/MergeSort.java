import java.util.Arrays;
import java.util.Random;

/**
 * Created by svetlana on 23/09/14.
 */
public class MergeSort{

    private int[] a;
    private int[] tmpArray;

    public static void main(String[] args) {
        Random random = new Random();
        int n = 10;
        MergeSort sortObj = new MergeSort();
        sortObj.a = new int[n];
        sortObj.tmpArray = new int[n];
        for (int i = 0; i < n; i++) {
            sortObj.a[i] = random.nextInt(100);
        }
        System.out.println("before sort: " + Arrays.toString(sortObj.a));
        sortObj.mergeSort();

        System.out.println("a after sort: " + Arrays.toString(sortObj.a));

    }

    public void mergeSort() {
        mergeSort(0, a.length - 1);
    }

    public void mergeSort(int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;

            mergeSort(start, middle);
            mergeSort(middle + 1, end);


            merge(start, middle, end);
        }
    }

    private void merge(int start, int middle, int end) {

        tmpArray = Arrays.copyOf(a,a.length);
        int i = start;
        int j = middle + 1;
        int k = start;
        while (i <= middle && j <= end) {
            if (tmpArray[i] <= tmpArray[j]) {
                a[k] = tmpArray[i];
                i++;
            } else {
                a[k] = tmpArray[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            a[k] = tmpArray[i];
            i++;
            k++;
        }

        while (j <= end) {
            a[k] = tmpArray[j];
            j++;
            k++;
        }
    }



}
