import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by svetlana on 28/09/14.
 */
public class Recursions {

    public static void main(String[] args) {
        System.out.println(stringPermutations("abcd"));
        printBrackets(4);
        PlaceQueen(0);

        ArrayList<Integer> subset = new ArrayList<Integer>();
        subset.add(1);
        subset.add(2);
        subset.add(3);
        subset.add(4);
        subset.add(5);

        System.out.println(getSubsets(subset, 0));
    }

    private static List<String> stringPermutations(String s) {
        List<String> result = new ArrayList();
        if ("".equals(s)) {
            result = new ArrayList<String>();
            result.add("");
            return result;
        } else {
            char first = s.charAt(0);
            String remainingString = s.substring(1);
            List<String> remainingPermutations = stringPermutations(remainingString);
            for  (String word : remainingPermutations) {
                for (int i = 0; i <= word.length(); i++) {
                    result.add(putCharAt(word, first, i));
                }
            }
            return result;
        }
    }

    private static String putCharAt(String s, char ch, int i) {
        String result = s.substring(0, i);
        result += ch;
        result += s.substring(i);
        return result;
    }

    private static void printBrackets(int l) {
        char str[] = new char[l* 2];
        printBrackets(l, l, str, 0);
    }

    private static void printBrackets(int l, int r, char[] str, int index) {
        if (l < 0 || r < l) {return;}
        if (l == 0 && r == 0) {
            System.out.println(str);
        } else {
            if (l > 0) {
                str[index] = '(';
                printBrackets(l - 1, r, str, index + 1);
            }
            if (r > l) {
                str[index] = ')';
                printBrackets(l, r - 1, str, index + 1);
            }
        }
    }

    static int columnForRow[] = new int[8];
    static boolean check(int row) {
        for (int i = 0; i < row; i++) {
            int diff = Math.abs(columnForRow[i] - columnForRow[row]);
            if (diff == 0 || diff == row - i) return false;
        }
        return true;
    }

    static void PlaceQueen(int row) {
        if (row == 8) {
            printBoard();
            return;
        }
        for (int i = 0; i < 8; i++) {
            columnForRow[row] = i;
            if (check(row)) {
                PlaceQueen(row + 1);
            }
        }
    }

    static void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print("{Queen " + i + " on row " + i + ", column " + columnForRow[i] + "}");
        }
        System.out.println("");
    }

    static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubSets;
        if (set.size() == index) {
            allSubSets = new ArrayList<ArrayList<Integer>>();
            allSubSets.add(new ArrayList<Integer>());
        } else {
            allSubSets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allSubSets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allSubSets.addAll(moresubsets);
        }
        return allSubSets;
    }


}
