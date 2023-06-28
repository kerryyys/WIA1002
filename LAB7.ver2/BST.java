package bst;

public class BST<E extends Comparable<E>> {

    int size;
    TreeNode<E> root;

    public BST() {
        root = null;
    }

    public boolean delete(E o) {
        if (isEmpty()) {
            return false;
        }

        TreeNode<E> current = root;
        TreeNode<E> parent = null;

        // Find the node to delete
        while (current != null) {
            if (o.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (o.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else {
                break; // Found the node to delete
            }
        }

        if (current == null) {
            return false; // Node not found
        }

        // Case 1: Node to delete has no children
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null; // Delete the root node
            } else if (parent.left == current) {
                parent.left = null; // Delete a left child
            } else {
                parent.right = null; // Delete a right child
            }
        } // Case 2: Node to delete has one child
        else if (current.left == null) {
            if (parent == null) {
                root = current.right; // Promote the right child as root
            } else if (parent.left == current) {
                parent.left = current.right; // Promote the right child
            } else {
                parent.right = current.right; // Promote the right child
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left; // Promote the left child as root
            } else if (parent.left == current) {
                parent.left = current.left; // Promote the left child
            } else {
                parent.right = current.left; // Promote the left child
            }
        } // Case 3: Node to delete has two children
        else {
            TreeNode<E> successorParent = current;
            TreeNode<E> successor = current.right;

            // Find the minimum node in the right subtree
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.element = successor.element; // Replace with the successor

            if (successorParent.left == successor) {
                successorParent.left = successor.right; // Delete the successor
            } else {
                successorParent.right = successor.right; // Delete the successor
            }
        }

        size--;
        return true;
    }

    public boolean search(E o) {
        if (isEmpty()) {
            return false;
        }

        TreeNode<E> current = root;
        while (current != null) {
            if (root.element.compareTo(o) < 0) {
                current = root.left;

            } else if (root.element.compareTo(o) > 0) {
                current = root.right;

            } else {
                return true; // element found
            }
        }
        return false;
    }

    public boolean insert(E o) {
        if (root == null) {
            root = new TreeNode<>(o);
        } else {
            TreeNode<E> current = root;
            TreeNode<E> parent;

            while (true) {
                parent = current;

                if (o.compareTo(current.element) <= 0) {
                    current = current.left;
                    if (current == null) {
                        parent.left = new TreeNode<>(o);
                        break;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = new TreeNode<>(o);
                        break;
                    }
                }
            }
        }

        size++;
        return true;
    }

    public void inorder() {
        inorder_recursive(root);
        System.out.println();
    }

    public void inorder_recursive(TreeNode<E> current) {
        if (current != null) {
            inorder_recursive(current.left);
            System.out.print(current.element + " --> ");
            inorder_recursive(current.right);
        }
    }

    public void preorder() {
        preorder_recursive(root);
        System.out.println();
    }

    public void preorder_recursive(TreeNode<E> current) {
        if (current != null) {
            System.out.print(current.element + " --> ");
            preorder_recursive(current.left);
            preorder_recursive(current.right);
        }
    }

    public void postorder() {
        postorder_recursive(root);
        System.out.println();
    }

    public void postorder_recursive(TreeNode<E> current) {
        if (current != null) {
            postorder_recursive(current.left);
            postorder_recursive(current.right);
            System.out.print(current.element + " --> ");
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public static void display() {
        // waiting
    }

    public E getMin() {
        TreeNode<E> current = root;

        while (current.left != null) {
            current = current.left;
        }
        return current.element;
    }

    public E getMax() {
        TreeNode<E> current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.element;
    }

    public int countOcc(E o) {
        return countOcc(root, o);
    }

    private int countOcc(TreeNode<E> current, E o) {
        if (current == null) {
            return 0;
        }

        int count = 0;
        if (o.equals(current.element)) {
            count++;
        }

        count += countOcc(current.left, o);
        count += countOcc(current.right, o);

        return count;
    }

    public int getTotal() {
        return getTotalValue(root);
    }

    public int getTotalValue(TreeNode<E> current) {
        if (current == null) {
            return 0;
        }
        int total = 0;
        total += getTotalValue(current.left);
        total += getTotalValue(current.right);
        total += (Integer) current.element;

        return total;
    }
}

class TreeNode<E> {

    TreeNode<E> left;
    TreeNode<E> right;
    E element;

    public TreeNode(E element) {
        this.element = element;
    }

    public E getElement() {
        return this.element;
    }

}

