package CHPT12_Sorting;

public class MergeSort {
    private static int[] sorted;

    static void MergeSort(int[] a) {
        sorted = new int[a.length];
        MergeSort(a, 0, a.length-1);
        sorted = null;
    }

    static void MergeSort(int[] a, int left, int right) {
        if(left == right) return;   //left와 right가 같을 경우엔 프로그램 종료

        int mid = (left + right) / 2;       //mid값 배정

        MergeSort(a, left, mid);        //왼쪽 부분
        MergeSort(a, mid+1, right); //오른쪽 부분

        merge(a, left, mid, right);     //mergeSort
    }

    private static void merge(int[] a, int left, int mid, int right) {
        int l = left;       //왼쪽 부분 시작점
        int r = mid+1;      //오른쪽 부분 시작점
        int index = left;   //채워넣을 배열의 인덱스

        while(l <= mid && r <= right) {
            if(a[l] <= a[r]) {
                sorted[index] = a[l];
                index++;
                l++;
            }       //왼쪽 부분의 1번째 원소가 오른쪽 부분 r번째 원소보다 작거나 같을 경우,
                    //왼쪽 부분의 1번째 원소를 새 배열에 넣고 l과 index 증가
            else {
                sorted[index] = a[r];
                index++;
                r++;
            }       //오른쪽 부분의 r번째 원소가 왼쪽 부분 1번째 원소보다 작거나 같을 경우,
                    //오른쪽 부분의 r번째 원소를 새 배열에 넣고 r과 index 증가
        }

        if(l > mid) {
            while(r <= right) {
                sorted[index] = a[r];
                index++;
                r++;
            }
        }       //왼쪽 부분이 모두 새 배열에 들어가서 오른쪽 부분만 남아있을 경우,
                //오른쪽 부분의 나머지 원소들을 새 배열에 정렬
        else {
            while(l <= mid) {
                sorted[index] = a[l];
                index++;
                l++;
            }   //오른쪽 부분이 모두 새 배열에 들어가서 왼쪽 부분만 남아있을 경우,
                //왼쪽 부분의 나머지 원소들을 새 배열에 정렬
        }

        for (int i = 0; i < sorted.length; i++)
            System.out.print(sorted[i] + " ");
        System.out.print("\n");     //단계별로 출력

        for (int i = left; i <= right; i++)
            a[i] = sorted[i];       //정렬된 새 배열을 기존의 배열에 복사
    }

    public static void main(String[] args) {
        int[] array = new int[32];      //배열 생성

        for (int i = 0; i < 32; i++)
            array[i] = (int)(Math.random() * 32);       //생성된 배열에 랜덤하게 수 삽입

        System.out.print("랜덤 생성 배열 : ");
        for (int i = 0; i < 32; i++)
            System.out.print(array[i] + " ");
        System.out.print("\n");     //처음 생성된 배열 출력

        MergeSort(array);       //MergeSort 실행
    }
}
