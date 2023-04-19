import java.util.ArrayList;

public class VecUtil {
    // Vector Constructors
    public static ArrayList<CpuInt> arr2vecC(Class<CpuInt> cpuIntClass, int[] arr) {
        ArrayList<CpuInt> vec = new ArrayList<CpuInt>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            vec.add(new CpuInt(arr[i]));
        }
        return vec;
    }

    public static ArrayList<GpuInt> arr2vecG(Class<GpuInt> gpuIntClass,int[] arr) {
        ArrayList<GpuInt> vec = new ArrayList<GpuInt>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            vec.add(new GpuInt(arr[i]));
        }
        return vec;
    }

    public static ArrayList<CpuInt> onesC(Class<CpuInt> cpuIntClass, int size) {
        ArrayList<CpuInt> vec = new ArrayList<CpuInt>(size);
        for (int i = 0; i < size; i++) {
            vec.add(new CpuInt(1));
        }
        return vec;
    }

    public static ArrayList<GpuInt> onesG(Class<GpuInt> GpuIntClass,int size) {
        ArrayList<GpuInt> vec = new ArrayList<GpuInt>(size);
        for (int i = 0; i < size; i++) {
            vec.add(new GpuInt(1));
        }
        return vec;
    }

    // Printing Utility
    public static void printVec(ArrayList<? extends NumberInterface> vec) {
        String device = vec.get(0).getDevice();
        System.out.print(device);
        System.out.print("[");
        for (int i = 0; i < vec.size(); i++) {
            System.out.print(vec.get(i).toInteger());
            if (i != vec.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // Element-wise vector multiplication
    public static <T extends NumberInterface> ArrayList<T> mul(ArrayList<T> vec1, ArrayList<T> vec2) {
        if (vec1.size() != vec2.size()) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }

        ArrayList<T> result = new ArrayList<T>(vec1.size());
        for (int i = 0; i < vec1.size(); i++) {
            result.add((T) vec1.get(i).mul(vec2.get(i)));
        }
        return result;
    }

    // Scalar-vector multiplication
    public static <T extends NumberInterface<T>> ArrayList<T> mul(ArrayList<T> vec, T scalar) {
        ArrayList<T> result = new ArrayList<T>(vec.size());
        for (int i = 0; i < vec.size(); i++) {
            result.add((T) vec.get(i).mul(scalar));
        }
        return result;
    }
    public static <T extends NumberInterface<T>> T dot(ArrayList<T> a, ArrayList<T> b) {
        if (a.size() != b.size()) {
            throw new IllegalArgumentException("Vectors must have the same length.");
        }
        ArrayList<T> newVec = VecUtil.mul(a, b);
        T result = newVec.get(0).fromInteger(0); // Initialize result with 0
        for (T obj : newVec) {
            result = result.add(obj);
        }
        return result;
    }
}

