/**
 * Created by svetlana on 28/09/14.
 */
public class RedBlackTree<Key extends Comparable<Key>, Value> {

    public static void main(String[] args) {
        RedBlackTree<String, Integer> tree = new RedBlackTree<String, Integer>();
        tree.put("A", 8);
        tree.put("X", 4);
        tree.put("E", 12);
        tree.put("H", 5);
        tree.put("L", 11);
        tree.put("M", 9);
        tree.put("P", 10);
        tree.put("R", 3);
        tree.put("S", 0);
        tree.put("C", 7);

        tree.printInOrder(tree.root);
        System.out.println("");


        Queue<String> nodes = tree.keys();

        while (!nodes.isEmpty()) {
            String key = nodes.pop();
            Integer value = tree.get(key);
            System.out.print("Key is " + key + ", Value is " + value + "; ");
        }
        System.out.println("");
        System.out.println("Max is " + tree.max());
        System.out.println("Min is " + tree.min());
    }

    private void printInOrder(Node x) {
        if (x.left != null) {
            printInOrder(x.left);
        }
        System.out.print(x.key + " ");
        if (x.right != null) {
            printInOrder(x.right);
        }
    }


    public static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N; //subtree count

        public Node(Key key, Value val, boolean color, int N) {
            this.key = key;
            this.val = val;
            this.color = color;
            this.N = N;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", val=" + val +
                    '}';
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.N;
    }

    public int size() {
        return size(root);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmpRes = key.compareTo(x.key);
            if (cmpRes < 0) x = x.left;
            else if (cmpRes > 0) x = x.right;
            else return x.val;
        }
        return null;
    }

    public boolean contains(Key key) {
        return (get(key) != null);
    }

    public void put(Key key, Value val) {
        root = put(root, key ,val);
        root.color = BLACK;
    }

    public Node put(Node h, Key key, Value val) {
        if (h == null) return new Node(key, val, RED, 1);

        int cmp = key.compareTo(h.key);

        if (cmp < 0) {
            h.left = put(h.left, key , val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.val = val;
        }

        if (isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left)) h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right)) flipColors(h);

        h.N = size(h.left) + size(h.right) + 1;

        return h;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private void flipColors(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public Key min() {
        if (isEmpty()) return null;
        return min(root).key;
    }

    public Node min(Node h) {
        if (h.left == null) return h;
        return min(h.left);
    }

    public Key max() {
        return max(root).key;
    }

    public Node max(Node h) {
        if (h.right == null) return h;
        return max(h.right);
    }

    public Queue<Key> keys() {
        return keys(min(), max());
    }

    public Queue<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo ,hi);
        return queue;
    }

    public void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <=0 && cmphi >= 0) queue.push(x.key);
        if (cmphi > 0 ) keys(x.right, queue, lo, hi);
    }
}
