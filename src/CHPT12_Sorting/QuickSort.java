package CHPT12_Sorting;

public class QuickSort {
    static void QuickSort(int[] a) {
        QuickSort(a, 0, a.length-1);
    }
    static void QuickSort(int[] a, int low, int high) {
        if (low >= high)
            return;

        int pivot = partition(a, low, high);
        //왼쪽과 오른쪽으로 적절히 정렬된 배열의 pivot값 할당

        QuickSort(a, low, pivot-1);
        QuickSort(a, pivot+1, high);    //왼쪽과 오른쪽으로 나누어 MergeSort의 방식을 따름
    }

    static int partition(int[] a, int left, int right) {
        int l = left;
        int h = right;
        int pivot = a[left];       //pivot 값은 배열의 첫번째에 저장된 수로 설정

        while (l < h) {
            while(a[h] > pivot && l < h)
                h--;       //h가 l보다 크면서, h의 요소가 pivot보다 작거나 같은 원소를
                            //찾을때까지 h 감소

            while(a[l] <= pivot && l < h)
                l++;        //h가 l보다 크면서, l의 요소가 pivot보다 큰 원소를
                            //찾을때까지 l 증가

            swap(a, l, h);  //교환할 적절한 l과 h를 서로 교환
        }

        swap(a, left, l);   //맨 처음 설정했던 pivot과 l이 가리키는 원소 교환

        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.print("\n");     //단계별로 출력

        return l;       //pivot과 l이 교환되었다면 pivot이었던 원소는 l에 위치하므로, 최종적으로 l 리턴
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

        QuickSort(array);       //QuickSort 실행
    }
}
