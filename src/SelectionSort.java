public class SelectionSort {
    static void SelectionSort(int[] a) { SelectionSort(a, a.length); }
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

    public static void main(String[] args) {
        int[] array = new int[32];      //배열 생성

        for (int i = 0; i < 32; i++)
            array[i] = (int)(Math.random() * 32);       //생성된 배열에 랜덤하게 수 삽입

        System.out.print("랜덤 생성 배열 : ");
        for (int i = 0; i < 32; i++)
            System.out.print(array[i] + " ");
        System.out.print("\n");     //처음 생성된 배열 출력

        SelectionSort(array, array.length);
    }
}
