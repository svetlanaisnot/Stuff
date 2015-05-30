import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int A = 13;
        int B = 70;
        int C = 7;
        int D = 10;

        int min = findMin(A, B, C, D);

        List<Integer> dividers = findAllDividers(min);

        int maxDivider = 1;

        for (int divider : dividers) {
            if (A % divider == 0
                    && B % divider == 0
                    && C % divider == 0
                    && D % divider == 0 ) {
                maxDivider = divider;
                break;
            }
        }

        int minSum = (A + B + C + D) / maxDivider;
        System.out.println("Min quantity of pupils is " + minSum);
    }

    private static int findMin(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }

    private static List<Integer> findAllDividers(int a) {
        List<Integer> dividers = new ArrayList<Integer>();
        dividers.add(a);
        for (int i = a - 1; i >= 1; i-- ) {
            if (a % i == 0) {
                dividers.add(i);
            }
        }
        return dividers;
    }
    {
    System.out.println(2);
}

static {
        System.out.println(3);
        }
}
