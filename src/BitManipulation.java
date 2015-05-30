/**
 * Created by svetlana on 04/10/14.
 */
public class BitManipulation {

    public static void main(String[] args) {
        int res = updateBits(1024, 7, 3, 6);
        System.out.println(Integer.toBinaryString(res));
        System.out.println(convertIntToBinaryString(18));
        System.out.println(convertDoubleToString(0.5));
        System.out.println(Long.toBinaryString(Double.doubleToRawLongBits(0.5)));
        System.out.println(bitSwapsRequired(16, 7));
        System.out.println(swapOddEvenBits(10));
    }

    private static int updateBits(int n, int m, int i, int j) {
        int max = ~0;

        int left = max - ((1 << j) - 1);
        int right = ((1 << i) - 1);

        int mask = left | right;
        return (n & mask) | (m << i);
    }

    private static String convertIntToBinaryString(int val) {
        String res = "";
        while (val > 0) {
            int r = val % 2;
            res = r + res;
            val >>= 1;
        }
        return res;
    }

    private static String convertDoubleToString(double d) {
        StringBuffer sb = new StringBuffer();
        while (d > 0) {
            if (sb.length() > 32) return "ERROR";
            if (d == 1) {
                sb.append((int) d);
                break;
            }
            double r = d * 2;
            if (r >= 1) {
                sb.append(1);
                d = r - 1;
            } else {
                sb.append(0);
                d = r;
            }
        }
        return sb.toString();
    }

    private static int bitSwapsRequired(int a, int b) {
        int count = 0;
        for (int c = a ^ b; c != 0; c = c >> 1) {
            count += c & 1;
        }
        return count;
    }

    public static int swapOddEvenBits(int x) {
        return ((( x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1));
    }
}
