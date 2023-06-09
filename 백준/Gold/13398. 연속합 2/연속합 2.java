import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = arr[0];

        int sum = arr[0];

        /* 연속합
        dp[1][0] = 10 = arr[0]
        dp[2][0]= 10 dp[1] + 0
        dp[3][0] = 13 dp[2] + 3 (arr[2])
        dp[4][0] = 14 dp[3] + 1 (arr[3])

        dp[i][0] = dp[i - 1][0] + arr[i]

        */

        /* 연속합 빼기
        -4 뺐을 때
        dp[1][1] = 10 = dp[1][0] = arr[0]
        ---- =4
        dp[2][1] = 13  dp[1][1] + 3(arr[2])
        dp[3][1] = 14  dp[2][1] + 1(arr[3])
        dp[4][1] = 19  dp[3][1] + 5(arr[4])



        3뺐을 때
        dp[1][1] = 10    =dp[1][0] =arr[0]
        dp[2][1] = 10     dp[2][0]
        ---- 3
        dp[3][1] = 11     dp[2][1] + arr[2]
        dp[4][1] = 16     dp[3][1] + arr[3]

        dp[i][1] = dp[i-1][1] +arr[i]


         */


        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0] + arr[i], arr[i]); // 그냥 연속합
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]); // 뺀거 연속합

            sum = Math.max(sum,Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(sum);
    }
}
