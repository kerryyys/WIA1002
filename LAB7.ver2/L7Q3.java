package bst;
import java.util.*;
public class L7Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Infix Expression: ");
        String infixExpression = scanner.nextLine();

        BSTExpression bstExpression = new BSTExpression();
        bstExpression.insertExpression(infixExpression);

        System.out.println("The number of elements in the tree: " + bstExpression.getSize());
        System.out.println("The tree elements - Inorder:");
        bstExpression.printInorder();
        System.out.println("The tree elements - Preorder:");
        bstExpression.printPreorder();
        System.out.println("The tree elements - Postorder:");
        bstExpression.printPostorder();
    }
}

class BSTExpression {
    private Node root;
    private int size;

    public BSTExpression() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public void insertExpression(String expression) {
        String[] tokens = expression.split("(?<=[-+*/()])|(?=[-+*/()])");
        for (String token : tokens) {
            insert(token);
        }
    }

    private void insert(String token) {
        if (root == null) {
            root = new Node(token);
        } else {
            insert(root, token);
        }
        size++;
    }

    private void insert(Node currentNode, String token) {
        if (currentNode.left == null) {
            currentNode.left = new Node(token);
        } else if (currentNode.right == null) {
            currentNode.right = new Node(token);
        } else {
            if (currentNode.left.data.equals("(")) {
                insert(currentNode.left, token);
            } else {
                insert(currentNode.right, token);
            }
        }
    }

    public void printInorder() {
        printInorder(root);
        System.out.println();
    }

    private void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print("<-- " + node.data + " ");
            printInorder(node.right);
        }
    }

    public void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(Node node) {
        if (node != null) {
            System.out.print("<-- " + node.data + " ");
            printPreorder(node.left);
            printPreorder(node.right);
        }
    }

    public void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(Node node) {
        if (node != null) {
            printPostorder(node.left);
            printPostorder(node.right);
            System.out.print("<-- " + node.data + " ");
        }
    }

    private class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
}


