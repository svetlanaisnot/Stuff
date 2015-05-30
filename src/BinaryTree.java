/**
 * Created by svetlana on 26/09/14.
 */
public class BinaryTree {
    private int value;

    private BinaryTree left;
    private BinaryTree right;
    private BinaryTree root;

    BinaryTree(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(20);
        tree.setRoot(tree);
        tree.insert(10);
        tree.insert(15);
        tree.insert(5);
        tree.insert(30);
        tree.insert(40);
        tree.insert(25);
        tree.insert(27);

        tree.preOrder();
        System.out.println("");
        tree.postOrder();
        System.out.println("");
        tree.inOrder();
        System.out.println("");

        tree.remove(20);
        tree.inOrder();
        System.out.println("");
        tree.preOrder();
        System.out.println("");

    }

    public void remove(int i) {
        if (value == i) {
            BinaryTree parent  = findParentOfMostLeftNodeInRightSubTree(getRoot());
            value = parent.left.value;
            parent.left = parent.left.right;

        }  else {
            if (i < value && left != null) {
                left.remove(i);
            } else if (right != null) {
                right.remove(i);
            }
        }
    }

    private BinaryTree findMostLeftNode(BinaryTree tree) {
        BinaryTree result = null;
        do {
            result = tree.left;
            tree = tree.left;
        } while (tree == null);
        return result;
    }

    public BinaryTree getRoot() {
        return this.root;
    }

    private BinaryTree findParentOfMostLeftNodeInRightSubTree(BinaryTree root) {
        if (root.right == null) {
            return root;
        }
        BinaryTree result = root.right;
        if (result.left == null) {
            return root;
        }

        while (result.left.left != null) {
            result = result.left;
        }

        return result;
    }

    public void insert(int i) {
        if (i == value) {
            //do nothing
        } else {
            if (i < value) {
                if (left != null) {
                    left.insert(i);
                } else {
                    left = new BinaryTree(i);
                }
            }
            if (i > value) {
                if (right != null) {
                    right.insert(i);
                } else {
                    right = new BinaryTree(i);
                }
            }
        }

    }

    public void preOrder() {
        System.out.print(value + " ");
        if (left != null) {
            left.preOrder();
        }
        if (right != null) {
            right.preOrder();
        }
    }

    public void postOrder() {
        if (left != null) {
            left.postOrder();
        }
        if (right != null) {
            right.postOrder();
        }
        System.out.print(value + " ");
    }

    public void inOrder() {
        if (left != null) {
            left.inOrder();
        }
        System.out.print(value + " ");
        if (right != null) {
            right.inOrder();
        }
    }

    public void setRoot(BinaryTree root) {
        this.root = root;
    }
}
