import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //갯수
        int K = Integer.parseInt(st.nextToken()); //총량

        int[] W = new int[N + 1]; // 무게
        int[] V = new int[N + 1]; // 밸류
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[][] dp = new int[N+1][K+1];
        // int[][] -> 원하는 무게 혹은 밸류만 꺼내오기 힘듬
        // map<Integer,Integer>  -> key 값으로 밸류를 가져오는 데 i를 1 2 3 4 돌려면
        // Iterator로 가져오는데 이게 for 안에 들어가면 또 순회를 하기 때문에 3중 for문이 될 가능성이 있음

        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        // W[1] = 6 ... W[4] = 5

        for(int i=1; i<=N;i++){
            for(int j=1; j<=K; j++){  // 무게를 더 담을 수 있는 경우만 계산했을때는 OutOfBound 뜸
                if(W[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - W[i]] + V[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
