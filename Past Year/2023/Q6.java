public class Q6 {
    public static void main(String[] args){
        BST bst = new BST();
        int[] arr = {34,27,56,12,31,36,66,18,29,33,40,64,100,38,99};

        System.out.println("Original Order");
        for(int i=0;i<arr.length;i++){
            bst.insert(arr[i]);
            System.out.print(arr[i] + "->");
        }

        System.out.println("\nInorder");
        bst.inorder();

        System.out.println("\nPostOrder");
        bst.postorder();

        System.out.println("\nPreOrder");
        bst.preorder();

        System.out.println("\n\nAfter converting BST to CDLL:");
        Node<Integer> head = bst.inorderToCDLL(bst.root);
        printCDLL(head);
        
        System.out.println("\n\nAfter deleting 12, 34 and 66");
        bst.delete(12);
        bst.delete(34);
        bst.delete(66);
        
        System.out.println("\nInorder");
        bst.inorder();

        System.out.println("\nPostOrder");
        bst.postorder();

        System.out.println("\nPreOrder");
        bst.preorder();

        
    }

    public static void printCDLL(Node<Integer> head) {
        Node<Integer> current = head;
        do {
            System.out.print(current.element + "->");
            current = current.right;
        } while (current != null);
    }
}
