/**
 * Created by svetlana on 05/09/14.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = i ;
        }

        int x = 6;

        System.out.println("Position of x in a is " + binarySearch(a, x));
    }

    private static int binarySearch(int[] a, int x) {
        return binarySearch(a, x, 0, a.length - 1);
    }

    private static int binarySearch(int[] a, int x, int l, int r) {
        if (r < l) {
            return -1;
        }

        int m = (l + r) /2;

        if (a[m] == x) {
            return m;
        } else if (a[m] > x) {
            return binarySearch(a, x, l, m -1);
        } else {
            return binarySearch(a, x, m + 1, r);
        }
    }
}
