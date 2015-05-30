/**
 * Created by svetlana on 18/09/14.
 */
public class SubStringFinder {

    public static void main(String[] args) {
        System.out.println(findSubString("AAAABRACADABRA", "ABRA"));
    }

    public static int findSubString(String s, String subString) {
        if (s == null || s.length() == 0 || subString == null || subString.length() == 0) {
            return -1;
        }

        int j;

        for (int i = 0; i < s.length() - subString.length(); i++) {
            if (s.charAt(i) == subString.charAt(0)) {
                for (j = i + 1; j < i + subString.length() - 1; j++) {
                    if (s.charAt(j) != subString.charAt(j - i)) {
                        break;
                    }
                }
                if (j == i + subString.length() - 1) {
                    return j - subString.length() + 1;
                }
            }
        }

        return -1;

    }
}
