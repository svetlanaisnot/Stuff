import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by svetlana on 23/09/14.
 */
public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        queue.add(20);
        queue.add(15);
        queue.add(10);
        while (queue.size() > 0) {
            System.out.println(queue.poll());
        }
    }

    public static class StringLengthComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() == o2.length() ? 0 : o1.length() < o2.length() ? -1 : 1;
        }
    }
}
