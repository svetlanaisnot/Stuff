import java.util.LinkedList;

/**
 * Created by svetlana on 26/09/14.
 */
public class Stack<T> {

    LinkedList<T> elements = new LinkedList<T>();

    public void push(T t) {
        elements.addFirst(t);
    }

    public T pop() {
        return elements.pollFirst();
    }

    public T peek() {
        return elements.peekFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public T get(int index) {
        return elements.get(index);
    }

}
