public class BST {
    Node<Integer> root;
    int size = 0;

    public void insert(int e) {
        if (root == null) {
            root = new Node<>(e);
            return;
        }
        Node<Integer> current = root;
        Node<Integer> parent = current;
        while (current != null) {
            if (e < current.element) {
                parent = current;
                current = current.left;
            } else if (e > current.element) {
                parent = current;
                current = current.right;
            } else {
                return;
            }
        }
        if (e < parent.element) {
            parent.left = new Node<>(e);
        } else {
            parent.right = new Node<>(e);
        }
        this.size++;
    }

    public void delete(int o) {
        if (root == null) {
            return;
        }

        Node<Integer> current = root;
        Node<Integer> parent = null;

        // Find the node to delete
        while (current != null) {
            if (o < current.element) {
                parent = current;
                current = current.left;
            } else if (o > current.element) {
                parent = current;
                current = current.right;
            } else {
                break;
            }
        }

        if (current == null) {
            return; // Node not found
        }

        // Case 1: Node to delete has no children
        if (current.left == null && current.right == null) {
            if (parent == null) {
                root = null; 
            } else if (parent.left == current) {
                parent.left = null; 
            } else {
                parent.right = null; 
            }
        } // Case 2: Node to delete has one child
        else if (current.left == null) {
            if (parent == null) {
                root = current.right; 
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right; 
            }
        } else if (current.right == null) {
            if (parent == null) {
                root = current.left; 
            } else if (parent.left == current) {
                parent.left = current.left; 
            } else {
                parent.right = current.left; 
            }
        } // Case 3: Node to delete has two children
        else {
            Node<Integer> successorParent = current;
            Node<Integer> successor = current.right;

            // Find the minimum node in the right subtree
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.element = successor.element; // Replace with the successor

            if (successorParent.left == successor) {
                successorParent.left = successor.right; 
            } else {
                successorParent.right = successor.right; 
            }
        }
        size--;
    }

    public void inorder() {
        PassInOrder(root);
    }

    private void PassInOrder(Node<Integer> root) {
        if (root != null) {
            PassInOrder(root.left);
            System.out.print(root.element + "->");
            PassInOrder(root.right);
        }else return;
    }

    public void postorder() {
        PassPostOrder(root);
    }

    private void PassPostOrder(Node<Integer> root) {
        if (root != null) {
            PassPostOrder(root.left);
            PassPostOrder(root.right);
            System.out.print(root.element + "->");
        }else return;
    }

    public void preorder() {
        PassPreOrder(root);
    }

    private void PassPreOrder(Node<Integer> root) {
        if (root != null) {
            System.out.print(root.element + "->");
            PassPreOrder(root.left);
            PassPreOrder(root.right);
        }else return;
    }

    // Method to convert BST to Circular Doubly Linked List (CDLL)
    public Node<Integer> inorderToCDLL(Node<Integer> root) {
        if (root == null) {
            return null;
        }

        // Convert left subtree to CDLL
        Node<Integer> leftCDLL = inorderToCDLL(root.left);

        // Find the last node in the left CDLL
        Node<Integer> lastLeft = leftCDLL;
        while (lastLeft != null && lastLeft.right != null) {
            lastLeft = lastLeft.right;
        }

        // Convert right subtree to CDLL
        Node<Integer> rightCDLL = inorderToCDLL(root.right);

        // Create a new node for the current root
        Node<Integer> newNode = new Node<>(root.element);

        // Connect the left and right CDLL to the new node
        newNode.right = rightCDLL;
        if (rightCDLL != null) {
            rightCDLL.left = newNode;
        }

        // Connect the new node to the last node in the left CDLL
        if (lastLeft != null) {
            newNode.left = lastLeft;
            lastLeft.right = newNode;
        } else {
            leftCDLL = newNode; // If leftCDLL is empty, the new node becomes the head of CDLL
        }

        return leftCDLL; // Return the head of the CDLL
    }
}

class Node<E> {
    Node<E> right;
    Node<E> left;
    E element;

    public Node(E element) {
        this.element = element;
        right = null;
        left = null;
    }
}
