//1018 체스판 칠하기

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

/* 브루트포스
 * 체스판을 만들어 다시 칠하는 메서드
 * NxM 크기의 체스판을 처음부터 돌아가며 'W','B' 값 확인
 * 클래스 전체에서 쓰이기 때문에 아래 두 변수는 전역 변수로 생성
 * @param arr:MxN 크기의 배열 생성
 * @param min:8*8 크기의 가장 작은 체스판
 *
 */

public class Main {
    public static boolean[][] arr;
    public static int min = 64;

    public static void main(String[] args) throws  IOException{
        /*
         * N M 숫자를 reader 로 입력 받아 st로 토큰화한 후 Integer 형 변환을 통해
         * N M에 저장
         */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");

        int N= Integer.parseInt(st.nextToken());
        int M= Integer.parseInt(st.nextToken());

        arr= new boolean[N][M];                           //NxM의 체스판 생성

        //체스판의 처음이 'W'일 경우와 'B'일 경우 분기
        for (int i =0; i<N; i++){
            String str =reader.readLine();
            for(int j=0; j<M; j++){
                arr[i][j]= str.charAt(j) == 'W';
            }
        }
        int xAxis= N - 7;
        int yAxis= M - 7;
        //find 메서드 호출하며 순회하여 다시 칠해야하는 체스판 개수를 출력
        for(int i=0; i<xAxis; i++){
            for(int j=0; j<yAxis; j++){
                find (i,j);
            }
        }
        System.out.println(min);

    }

    /*
     *체스판의 좌표를 하나씩 탐색하여 색 비교를 한 후 색이 같다면 그대로 반환 아니라면
     *반대색으로 변경해주는 메서드 find()
     */
    public static void find(int x, int y){
        int x_final =x + 8;
        int y_final =y + 8;
        int cnt = 0;

        boolean firstColor =arr[x][y];

        for(int i = x; i<x_final; i++){
            for(int j = y; j<y_final; j++){
                if(arr[i][j] != firstColor){
                    cnt++;
                }
                firstColor=(!firstColor);
            }
            firstColor= !firstColor;
        }
        cnt=Math.min(cnt, 64- cnt);
        min=Math.min(min,cnt);
    }
}

