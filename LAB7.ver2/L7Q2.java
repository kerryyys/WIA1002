package Stack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class L7Q2 {
    public static void main(String[] args) {
        BST<String> wordFrequency = new BST<>();

        try {
            File file = new File("l7q2.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                word = word.replaceAll("[^a-zA-Z]", ""); // Remove non-alphabetic characters
                if (!word.isEmpty()) {
                    wordFrequency.insert(word);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        System.out.println("Word Frequency:");
        wordFrequency.inorder();
    }
}

class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public BST() {
        root = null;
    }

    public void insert(E element) {
        root = insert(root, element);
    }

    private TreeNode<E> insert(TreeNode<E> node, E element) {
        if (node == null) {
            return new TreeNode<>(element);
        }

        int compareResult = element.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(node.left, element);
        } else if (compareResult > 0) {
            node.right = insert(node.right, element);
        }

        return node;
    }

    public void inorder() {
        inorder(root);
    }

    private void inorder(TreeNode<E> node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.element + " -->");
            inorder(node.right);
        }
    }

    private static class TreeNode<E> {
        E element;
        TreeNode<E> left;
        TreeNode<E> right;

        public TreeNode(E element) {
            this.element = element;
            left = null;
            right = null;
        }
    }
}

