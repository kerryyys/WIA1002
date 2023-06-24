package LinkedList;

import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("ARS");
        linkedList.addLast("CHE");
        linkedList.addLast("LEI");
        linkedList.addLast("MAN");
        linkedList.addLast("LIV");
        linkedList.addLast("TOT");

        System.out.println("The list consists of: " + linkedList);

        linkedList.removeWordsWithCharacter('A');

        System.out.println("The updated list consists of: " + linkedList);
    }
}
