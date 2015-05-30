/**
 * Created by svetlana on 02/10/14.
 */
public class LinkedListExample {

    private class Stack<T> {
        Node<T> top;

        T pop() {
            if (top != null) {
                T item = top.value;
                top = top.next;
            }
            return null;
        }

        void push(T item) {
            Node node = new Node();
            node.value = item;
            node.next = top;
            top = node;
        }
    }

    private class Queue<T> {
        Node<T> first, last;

        void enqueue(T item) {
            if (first == null) {
                last = new Node<T>();
                last.value = item;
                first = last;
            } else {
                last.next = new Node();
                last.next.value = item;
            }
        }

        T dequeue() {
            if (first != null) {
                T res = first.value;
                first = first.next;
                return res;
            }
            return null;
        }
    }

    private class Node<T> {
        private T value;
        private Node next = null;

        public void addToTail(T t) {
            Node node = new Node();
            node.value = t;
            Node head = this;
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
        }

        public Node deleteNode(Node node, Node head) {
            if (head.value.equals(node.value)) {
                return head.next;
            }
            while (head.next != null) {
                if (head.next.value.equals(node.value)) {
                    head.next = head.next.next;
                    return head;
                }
                head = head.next;
            }
            return null;
        }
    }
}
