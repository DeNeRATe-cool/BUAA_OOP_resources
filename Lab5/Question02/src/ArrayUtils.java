import java.lang.reflect.Array;

public class ArrayUtils {
    public static <T> void printArray(T array) {
        if(array == null) {
            System.out.print("null");
            return;
        }

        System.out.print("[");
        if(!array.getClass().isArray()) {
            System.out.print(array);
        } else {
            int n = Array.getLength(array);
            for(int i = 0; i < n; i++) {
                printArray(Array.get(array, i));
                if(i != n - 1) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3};
        int[][] arr2 = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};

        ArrayUtils.printArray(arr1);
        System.out.println();
        ArrayUtils.printArray(arr2);
    }
}