import java.util.Arrays;

public class DIOStack<DIO> {
    private DIO[] array = (DIO[]) new Object[1];
    private int size = 0;

    public void push(DIO o) {
        resize(size+1);
        array[size-1] = o;
    }

    public DIO pop() {
        if (isEmpty()) {
            return null;
        }
        DIO o =array[size-1];
        resize(size-1);
        return o;
    }

    public DIO peek() {
        if (isEmpty()) {
            return null;
        }
        return array[size - 1];

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOf(array, size));
    }

    private void resize(int size) {
        DIO[] newArray = (DIO[]) new Object[size];
    System.arraycopy(array, 0, newArray, 0, Math.min(this.size, size));
    array = newArray;
    this.size = size;
    }
}
