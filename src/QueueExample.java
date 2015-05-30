import java.util.LinkedList;
import java.util.List;

/**
 * Created by svetlana on 22/09/14.
 */
public class QueueExample {

    private static final int N = 10;
    private int head = 0;
    private int current = head;
    private int[] elements = new int[N];

    public void push(int elem) {
        elements[current] = elem;
        current = (current  + 1 ) % N;
    }

    public int pop() {
        int result  = elements[head];
        head = (head + 1) % N;
        return result;
    }

    public static void main(String[] args) {
        QueueExample queue = new QueueExample();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }

}
