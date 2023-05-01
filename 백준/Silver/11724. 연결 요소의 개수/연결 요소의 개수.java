// 11724 인접행렬로

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] node;
    static boolean[] check;
    static int N,M;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        node = new int[N+1][N+1];
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            node[u][v] = node[v][u] = 1;
        }

        check = new boolean[N+1];
        int cnt =0;

        for(int k=1; k<=N; k++){
            if(!check[k]){
                dfs(k);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
    
    public static void dfs(int i){
        check[i] = true;
        for(int j =1; j <=N; j++){
            if(node[i][j] == 1 && !check[j]){
                dfs(j);
            }
        }
    }
}