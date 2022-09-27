// 10816 숫자카드 2
// N개의 숫자를 입력 받아 만든 배열에 M 개의 숫자를 입력 받아 만든 배열의 요소가 몇 개 들어 있는지 count

import java.util.Scanner;
import java.util.Arrays;


public class Main {

    public static void main(String[] args)  {
        Scanner scan = new Scanner((System.in));
        int N = scan.nextInt();
        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);                             // 이분 탐색을 위한 정렬

        int M = scan.nextInt();
        StringBuilder sb = new StringBuilder();
        /*
        * 출력값을 공백을 하나 주고 출력하기 위해 문자열을 더한 sb 출력
         */
        for(int i=0; i<M; i++){
            int target = scan.nextInt();
            sb.append(upperBound(arr,target)-lowerBound(arr, target)).append(' ');  //탐색 진행
        }
        System.out.println(sb);
    }
    /*
    * 구하고자 하는 target ; M[i]가 존재 하는지 count 하는 메서드
     */
    private static int lowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length;

        while(low<high){
            int mid = (low+high)/2;
            if(target <= arr[mid]){
                high=mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    private  static  int upperBound(int[] arr, int target){
        int low =0;
        int high = arr.length;

        while(low<high){
            int mid =(low+high)/2;
            if(target < arr[mid]){
                high = mid;
            }else{
                low = mid +1;
            }
        }
        return low;
    }
}
