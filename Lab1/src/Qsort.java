public class Qsort {
    /**
     * 对一个int数组快速排序，结果是升序的，并且不会开辟额外的数组空间
     * @param arr 待排序的数组
     * @return 升序排列好的 arr，如果 arr == null，则返回 null
     */

    private static void quick_sort(int[] arr, int n, int l, int r) {
        if(l >= r) return;

        int loc = l, temp = 0;
        for(int i = l + 1; i <= r; i++) {
            if(arr[i] < arr[l]) {
                loc++;
                temp = arr[loc];
                arr[loc] = arr[i];
                arr[i] = temp;
            }
        }
        temp = arr[l];
        arr[l] = arr[loc];
        arr[loc] = temp;
        quick_sort(arr, n, l, loc - 1);
        quick_sort(arr, n, loc + 1, r);
    }

    public static int[] qsort(int[] arr) {
        if(arr == null) return null;
        else if(arr.length == 0) return arr;
        quick_sort(arr, arr.length, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 4, 7, 1, 2};
        arr = qsort(arr);
        for(int item: arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
