/**
 * Created by svetlana on 04/09/14.
 */
public class Logistics {

    private static final int MAX_IN_BUS = 60;
    private static final int MAX_IN_TAXI = 3;

    public static void main(String[] args) {
        int N = 65;
        int A = 3000;
        int B = 2000;

        int busQ = 0;
        int taxiQ = 0;

        if (A * getTransportQuantity(N, MAX_IN_BUS) > B * getTransportQuantity(N, MAX_IN_TAXI)) {
            taxiQ = getTransportQuantity(N, MAX_IN_TAXI);
        } else {
            busQ = N / MAX_IN_BUS;
            int remaining = N % MAX_IN_BUS;

            if (A > B * getTransportQuantity(remaining, MAX_IN_TAXI)) {
                taxiQ = getTransportQuantity(remaining, MAX_IN_TAXI);
            } else {
                busQ++;
            }
        }

        System.out.println(String.format("busQ is %d, taxiQ is %d", busQ, taxiQ));

    }

    private static int getTransportQuantity(int n, int max) {
       return Math.round((float) n / (float) max) ;
    }
}
