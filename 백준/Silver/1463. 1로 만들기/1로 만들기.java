import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(min(N,0));
    }

    static int min(int N , int cnt){
        if(N<2){           // N = 1 , cnt = 1
            return cnt;  
        }
        /*
        N이 2의 배수일 때와 3의 배수 일때 중 최솟값 선택 및, N을 2,3으로 나눈 나머지가 존재한다면 횟수에 +1 
        */
        return Math.min(min(N/2, cnt +1 + (N%2)),min(N/3,cnt+1+(N%3))); 
    }
}