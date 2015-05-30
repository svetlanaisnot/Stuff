/**
 * Created by svetlana on 04/09/14.
 */
public class Euclede {
    public static void main(String[] args) {

        int a = 56;
        int b = 98;
        do {
          if (a > b) { a = a - b; } else { b = b - a; }
        } while (!(a == 0 || b == 0));

        System.out.println(a);

    }
}
