import java.util.NoSuchElementException;
import java.util.Scanner;
public class StudentManagementSystem<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;

    public StudentManagementSystem(){
        this.head = null;
        this.tail = null;
    }

    public void add(E e){
        Node<E> newNode = new Node<>(e);
        if(this.head == null){
            this.head = this.tail = newNode;
        }
        else{
            this.tail.next = newNode; //direct assign tail.next = newNode next
            this.tail = newNode;
        }
        size++;
    }
    public void removeElement(E e){
        if(this.size == 0) throw new NullPointerException();

        if(this.head.element == e){
            this.head = this.head.next;
            size--;
            return; //why return nothing
        }

        Node<E> current = head;
        while(current.next != null){
            if(current.next.element.equals(e)){
                current.next = current.next.next;
                size--;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException();
    }
    public void printList(){
        Node<E>current = head;
        while(current != null){
            System.out.printf("%s",current.element.toString());
            current = current.next;
            System.out.printf("%s ",(current == null)?".":",");
        }
    }
    public int getSize(){
        return size;
    }
    public boolean contains(E e){
        Node<E> current = head;
        while(current != null){
            if(current.element.equals(e))
                return true;
            current=current.next;
        }
        return false;
    }
    public void replace(E e, E newE){
        if(this.size == 0)
            throw new NullPointerException();

        Node<E> current = this.head;
        while(current != null){
            if(current.element.equals(e)){
                current.element = newE;
                return;
            }
            current = current.next;
        }
        throw new NoSuchElementException();
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManagementSystem<String> sl = new StudentManagementSystem<>();

        // Add names to list
        System.out.println("Enter your student name list. Enter 'n' to end.....");
        String name = sc.nextLine();
        while (!name.equalsIgnoreCase("n")) {
            sl.add(name);
            name = sc.nextLine();
        }
        System.out.println();

        // Display details
        System.out.println("You have entered the following students' name :");
        sl.printList();
        System.out.printf("\n\nThe number of students entered is : %d\n", sl.getSize());
        System.out.println();


        // Rename details
        System.out.println("All the names entered are correct? Enter 'r' to rename the student name, 'n' to proceed.");
        char input = sc.nextLine().charAt(0);
        while (input != 'r' && input != 'n') {
            System.out.print("Enter 'r' or 'n':");
            input = sc.nextLine().charAt(0);
        }
        if (input == 'r') {
            System.out.println("\nEnter the existing student name that u want to rename :");
            name = sc.nextLine();
            while (!sl.contains(name)) {
                System.out.print("Name not found, please enter an existing student name: ");
                name = sc.nextLine();
            }
            System.out.println("\nEnter the new name :");
            sl.replace(name, sc.nextLine());
        }
        System.out.println();

        // Remove name
        System.out.println("Do you want to remove any of your student name? Enter 'y' for yes, 'n' to proceed.");
        input = sc.nextLine().charAt(0);
        while (input != 'y' && input != 'n') {
            System.out.print("Enter 'y' or 'n':");
            input = sc.nextLine().charAt(0);
        }
        if (input == 'y') {
            System.out.println("\nEnter a student name to remove :");
            name = sc.nextLine();
            while (!sl.contains(name)) {
                System.out.print("Name not found, please enter an existing student name: ");
                name = sc.nextLine();
            }
            sl.removeElement(name);
        }
        System.out.println();

        // Display updated
        System.out.printf("The number of updated student is :%d\n", sl.getSize());
        System.out.println("The updated students list is :");
        sl.printList();
        System.out.println();

        // Completion
        System.out.println("All student data captured complete. Thank you!");
        sc.close();
    }
}
