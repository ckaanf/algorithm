import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n + 1];
        int[] dp = new int[k + 1];
        dp[0] = 1; //초기값 설정 안해주니 0 나와서 1로 잡아줌

        for(int i =1; i<= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            for(int j = arr[i]; j<=k; j++){
                dp[j] = dp[j-arr[i]] + dp[j];
            }
        }
        System.out.println(dp[k]);
    }
}
