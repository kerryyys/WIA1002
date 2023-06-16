package L3Q1;

public class ArrayBag<T> implements BagInterface<T> {
    public static int DEFAULT_CAPACITY = 25;
    private int numberOfEntries;
    T[] bag;

    ArrayBag() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayBag(T[] bag) {
        this.bag = bag;
        numberOfEntries = bag.length;
    }

    @SuppressWarnings("unchecked")
    public ArrayBag(int capacity) {
        bag = (T[]) new Object[capacity];
    }

    @Override
    public int getCurrentSize() {
        return this.numberOfEntries;
    }

    @Override
    public boolean isFull() {
        return numberOfEntries == bag.length;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    @Override
    public boolean add(T e) {
        if (isFull()) {
            return false;
        }
        bag[numberOfEntries++] = e;
        return true;
    }

    @Override
    public T remove() {
        if (isEmpty()) {
            return null;
        }
        T temp = bag[numberOfEntries];
        bag[numberOfEntries] = null;
        return temp;
    }

    @Override
    public boolean remove(T e) {
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == e) {
                bag[i] = null;
                numberOfEntries--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < bag.length; i++) {
            bag[i] = null;
        }
        numberOfEntries = 0;

    }

    @Override
    public int getFrequencyOf(T e) {
        int count = 0;
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == e)
                count++;
        }
        return count;
    }

    @Override
    public boolean contains(T e) {
        for (int i = 0; i < bag.length; i++) {
            if (bag[i] == e) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T[] toArray() {
        T[] newArray = (T[]) new Object[numberOfEntries];
        for (int i = 0; i < numberOfEntries; i++) {
            newArray[i] = bag[i];
        }
        return newArray;
    }

    @Override
    public BagInterface<T> union(BagInterface<T> other) {
        T[] bag2 = other.toArray();
        ArrayBag<T> union = new ArrayBag<>(numberOfEntries + bag2.length);
        for (int i = 0; i < numberOfEntries; i++) {
            union.add(bag[i]);
        }
        for (int j = 0; j < bag2.length; j++) {
            union.add(bag2[j]);
        }
        return union;
    }

    @Override
    public BagInterface<T> intersection(BagInterface<T> other) {
    ArrayBag<T> intersection = new ArrayBag<>();
    T[] bag2 = other.toArray();

    for (T key : bag) {
        if (other.contains(key) && !intersection.contains(key)) {
            intersection.add(key);
        }
    }

    return intersection;
}

    @Override
    public BagInterface<T> difference(BagInterface<T> other) {
        ArrayBag<T> difference = new ArrayBag<>();
        T[] bag2 = other.toArray();

        for (T key : bag) {
            if (!other.contains(key)) {
                difference.add(key);
            }
        }
        for (T key : bag2) {
            if (!contains(key) && !difference.contains(key)) {
                difference.add(key);
            }
        }
        return difference;
    }
}
