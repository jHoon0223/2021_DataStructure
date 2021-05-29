public class Sorting {
    static void InsertionSort(int[] a) {
        InsertionSort(a, a.length);
    }
    static void InsertionSort(int[] a, int size) {
        for (int i = 1; i < size; i++) {
            int target = a[i];
            int j = i-1;

            while(j >= 0 && target < a[j]) {
                a[j+1] = a[j];
                j--;
            }

            a[j+1] = target;

            System.out.print(i + "단계 : ");
            for (int k = 0; k < size; k++)
                System.out.print(a[k] + " ");
            System.out.print("\n");
        }
    }

    static void SelectionSort(int[] a, int size) {
        for (int i = size-1; i > 0; i--) {
            int max = i;

            for (int j = i-1; j >= 0; j)
        }

    }

    public static void main(String[] args) {
        int[] array = {10, 5, 3, 6, 8, 9};

        InsertionSort(array, array.length);
    }
}