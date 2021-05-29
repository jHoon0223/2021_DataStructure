package CHPT12_Sorting;

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

    static void SelectionSort(int[] a) { InsertionSort(a, a.length); }
    static void SelectionSort(int[] a, int size) {
        int cnt = 0;

        for (int i = size-1; i > 0; i--) {
            int max = i;
            cnt++;

            for(int j = 0; j < i-1; j++) {
                if (a[j] > a[max])
                    max = j;
            }

            swap(a, max, i);

            System.out.print(cnt + "단계 : ");
            for (int k = 0; k < size; k++)
                System.out.print(a[k] + " ");
            System.out.print("\n");     //단계별로 출력
        }
    }

    static void swap(int[] a, int b, int c) {
        int temp;

        temp = a[b];
        a[b] = a[c];
        a[c] = temp;
    }

    private static int[] sorted;

    static void MergeSort(int[] a) {
        sorted = new int[a.length];
        MergeSort(a, 0, a.length-1);
        sorted = null;
    }
    static void MergeSort(int[] a, int left, int right) {
        if(left == right) return;

        int mid = (left + right) / 2;

        MergeSort(a, left, mid);
        MergeSort(a, mid+1, right);

        merge(a, left, mid, right);
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;
        int r = mid+1;
        int index = left;

        while(l <= mid && r <= right) {
            if(a[l] <= a[r]) {
                sorted[index] = a[l];
                index++;
                l++;
            }
            else {
                sorted[index] = a[r];
                index++;
                r++;
            }
        }

        if(l > mid) {
            while(r <= right) {
                sorted[index] = a[r];
                index++;
                r++;
            }
        }
        else {
            while(l <= mid) {
                sorted[index] = a[l];
                index++;
                l++;
            }
        }

        for (int i = 0; i < sorted.length; i++)
            System.out.print(sorted[i] + " ");
        System.out.print("\n");

        for (int i = left; i <= right; i++)
            a[i] = sorted[i];
    }

    static void QuickSort(int[] a) {
        QuickSort(a, 0, a.length-1);
    }
    static void QuickSort(int[] a, int low, int high) {
        if (low >= high)
            return;

        int pivot = partition(a, low, high);

        QuickSort(a, low, pivot-1);
        QuickSort(a, pivot+1, high);
    }

    static int partition(int[] a, int left, int right) {
        int l = left;
        int h = right;
        int pivot = a[left];

        while (l < h) {
            while(a[h] > pivot && l < h)
                h--;

            while(a[l] <= pivot && l < h)
                l++;

            swap(a, l, h);
        }

        swap(a, left, l);

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n");

        return l;
    }

    public static void main(String[] args) {
        int[] array = {10, 5, 3, 6, 8, 9};

        System.out.print("랜덤 생성 배열 : ");
        for (int i = 0; i < 6; i++)
            System.out.print(array[i] + " ");
        System.out.print("\n");     //처음 생성된 배열 출력

        QuickSort(array);
    }
}