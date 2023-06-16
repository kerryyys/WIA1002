package L3Q1;

public class ArrayBagDemo {
    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another string"};

        System.out.println("Bag 1:");
        testAdd(bag1, contentsOfBag1);
        displayBag(bag1);
        System.out.println();

        System.out.println("Bag 2:");
        testAdd(bag2, contentsOfBag2);
        displayBag(bag2);
        System.out.println();

        System.out.println("Bag 3: Union of Bag 1 and Bag 2:");
        BagInterface<String> bag3 = bag1.union(bag2);
        displayBag(bag3);
        System.out.println();

        System.out.println("Bag 4: Intersection of Bag 1 and Bag 2:");
        BagInterface<String> bag4 = bag1.intersection(bag2);
        displayBag(bag4);
        System.out.println();

        System.out.println("Bag 5: Difference of Bag 1 and Bag 2:");
        BagInterface<String> bag5 = bag1.difference(bag2);
        displayBag(bag5);
        System.out.println();
    }

    private static void testAdd(BagInterface<String> aBag, String[] content) {
        for (String key : content) {
            aBag.add(key);
        }
    }

    private static void displayBag(BagInterface<String> aBag) {
        Object[] newArray = aBag.toArray();
        for (int i = 0; i < aBag.getCurrentSize(); i++) {
            System.out.print(newArray[i] + " ");
        }
        System.out.println("\nThe size of this bag is: " + aBag.getCurrentSize());
    }
}
