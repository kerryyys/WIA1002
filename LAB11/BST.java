package BST;

import java.util.ArrayList;

public class BST<E extends Comparable<E>> {

    TreeNode<E> root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public boolean search(E e) {
        TreeNode<E> current = root;

        while (current != null)
            if (e.compareTo(current.element) < 0) {
                current = current.left; // Go left
            } else if (e.compareTo(current.element) > 0) {
                current = current.right; // Go right
            } else // Element matches current.element
                return true; // Element is found
        return false;
    }

    public boolean insert(E e) {
        if (root == null) {
            root = new TreeNode<>(e);
            return true;
        } else {
            // locate parent node
            TreeNode<E> current = root;
            TreeNode<E> parent = current;
            while (current != null)
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicated node not inserted
                }
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
            } else {
                parent.right = new TreeNode<>(e);
            }
        }
        this.size++;
        return true;
    }

    public int getSize() {
        return this.size;
    }

    public int height() {
        return this.height(root) - 1;
    }

    private int height(TreeNode<E> node) {
        if (node == null)
            return 0;

        int heightLeft = this.height(node.left);
        int heightRight = this.height(node.right);

        return Math.max(heightLeft, heightRight) + 1;
    }

    public E getRoot() {
        return this.root.element;
    }

    public E minValue() {
        TreeNode<E> current = this.root;
        E minValue = null;

        while (current != null) {
            minValue = current.element;
            current = current.left;
        }
        return minValue;
    }

    public E maxValue() {
        TreeNode<E> current = this.root;
        E maxValue = null;

        while (current != null) {
            maxValue = current.element;
            current = current.right;
        }
        return maxValue;
    }

    // return path from root leading to specified element
    public ArrayList<TreeNode<E>> path(E e) {

        if (!this.search(e))
            return null;

        ArrayList<TreeNode<E>> pathToElement = new ArrayList<>();
        TreeNode<E> current = this.root;

        while (current != null) {

            pathToElement.add(current);

            if (e.equals(current.element))
                break;

            current = (e.compareTo(current.element) < 0) ? current.left : current.right;
        }
        return pathToElement;
    }

    public boolean delete(E e) {
        if (!this.search(e)) {
            return false;
        }

        TreeNode<E> current = this.root;
        TreeNode<E> parent = current;

        while (current != null) {
            if (e.equals(current.element))
                break;

            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else {
                parent = current;
                current = current.right;
            }
        }
        if (current.element.compareTo(parent.element) < 0)
            this.swapDeleteNode(parent.left, current);

        else
            this.swapDeleteNode(parent.right, current);

        return true;
    }

    private void swapDeleteNode(TreeNode<E> parentNodeReference, TreeNode<E> current) {
        if (current.left == null) {
            parentNodeReference = current.right;
        } 
        else if (current.right == null) {
                parentNodeReference.right = current.left;
        } 
        else {
            TreeNode<E> tempNode = current;

            while (current != null) {
                tempNode = current;
                current = current.right;
            }

            parentNodeReference.element = tempNode.right.element;
            tempNode.right = null;
        }
    }


    public boolean clear() {
        this.deleteNode(this.root);
        return true;
    }

    private void deleteNode(TreeNode<E> node) {
        if (node.element != null) {
            this.deleteNode(node.left);
            node.left = null;
            this.deleteNode(node.right);
            node.right = null;
        }
    }

    // display inorder traversal from a subtree
    protected void inorder(TreeNode<E> root) {
        if (root != null) {
            this.inorder(root.left);
            System.out.printf("%s ", root.element);
            this.inorder(root.right);
        }
    }

    // display preorder traversal from a subtree
    protected void postorder(TreeNode<E> root) {
        if (root != null) {
            this.postorder(root.left);
            this.postorder(root.right);
            System.out.printf("%s ", root.element);
        }
    }

    protected void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.printf("%s ", root.element);
            this.preorder(root.left);
            this.preorder(root.right);
        }
    }
}
