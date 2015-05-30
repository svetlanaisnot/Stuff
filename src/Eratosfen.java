import java.util.Arrays;

/**
 * Created by svetlana on 04/09/14.
 */
public class Eratosfen {
    public static void main(String[] args) {
        int n = 250;

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i*i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        int num = 0;
        for (boolean val : isPrime) {
            if (val) {
                System.out.println(num);
            }
            num++;
        }

    }

    private static void codeForSave() {
        int n = 101;

        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;
        for (int i=2; i*i <= n; i++)
            if (isPrime[i])
                for (int j=i * i; j <= n; j+=i)
                    isPrime[j] = false;

        int num = 0;
        for (boolean val : isPrime) {
            if (val) {
                System.out.println(num);
            }
            num++;
        }
    }
}
