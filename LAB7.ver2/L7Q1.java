package bst;

import java.util.*;

public class L7Q1 {

    public static void main(String[] args) {
        Random rand = new Random();
        BST<Integer> treeBST = new BST<>();

        System.out.println("The random number are: ");
        for(int i = 0;i<10;i++){
            int num = rand.nextInt(21);
            treeBST.insert(num);
            System.out.print(num + " ");

        }
        System.out.println("\nThe number of element in the tree: " + treeBST.getSize());
        System.out.println();

        System.out.println("Inorder Traversal: ");
        treeBST.inorder();
        System.out.println("Preorder Traversal: ");
        treeBST.preorder();
        System.out.println("Postorder Traversal: ");
        treeBST.postorder();

        System.out.println("Minimum value: " + treeBST.getMin());

        System.out.println("Maximum value: " + treeBST.getMax());

        System.out.println("Total value: " + treeBST.getTotal());
        
        System.out.print("Enter a number to search: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        System.out.println("Number of occurence of " + input + " in the tree: " + treeBST.countOcc(input));

    }
}
