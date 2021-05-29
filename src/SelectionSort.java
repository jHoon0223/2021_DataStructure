public class SelectionSort {
    static void SelectionSort(int[] a) { SelectionSort(a, a.length); }
    static void SelectionSort(int[] a, int size) {
        int cnt = 0;

        for (int i = size-1; i > 0; i--) {
            if (a[size-1] == a[size-2])
                continue;       //중복되는 인덱스가 있으면, continue로 넘어가기

            int max = i;        //최대치 수 저장
            cnt++;      //횟수 카운트

            for(int j = 0; j < i-1; j++) {
                if (a[j] >= a[max])
                    max = j;
            }       //가장 큰 수를 찾으면 max변수에 저장,
            // 이때, 중복되는 수도 있기때문에 크거나 같으면 모두 max에 저장

            swap(a, max, i);        //현재 인덱스와 max 인덱스 교환

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
    }       //인자로 들어온 인덱스를 서로 교환해주는 swap함수

    public static void main(String[] args) {
        int[] array = new int[32];      //배열 생성

        for (int i = 0; i < 32; i++)
            array[i] = (int)(Math.random() * 32);       //생성된 배열에 랜덤하게 수 삽입

        System.out.print("랜덤 생성 배열 : ");
        for (int i = 0; i < 32; i++)
            System.out.print(array[i] + " ");
        System.out.print("\n");     //처음 생성된 배열 출력

        SelectionSort(array, array.length);     //선택정렬 실행
    }
}