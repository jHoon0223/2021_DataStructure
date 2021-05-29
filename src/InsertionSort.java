public class InsertionSort {
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
            System.out.print("\n");     //단계별로 출력
        }
    }

    public static void main(String[] args) {
        int[] array = new int[32];      //배열 생성

        for (int i = 0; i < 32; i++)
            array[i] = (int)(Math.random() * 32);       //생성된 배열에 랜덤하게 수 삽입

        System.out.print("랜덤 생성 배열 : ");
        for (int i = 0; i < 32; i++)
            System.out.print(array[i] + " ");
        System.out.print("\n");     //처음 생성된 배열 출력

        InsertionSort(array, array.length);     //삽입정렬 실행
    }
}