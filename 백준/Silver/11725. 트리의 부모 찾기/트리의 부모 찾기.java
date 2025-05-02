import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static ArrayList<Integer>[] arrayList;
    static int[] parent;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N + 1];
        parent = new int[N + 1];
        check = new boolean[N + 1];

        for(int i = 1; i<= N; i++){
            arrayList[i] = new ArrayList<>();
        }


        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayList[s].add(e);
            arrayList[e].add(s);
        }
        for(int i =1; i<=N; i++){
            if(!check[i]){
                dfs(i);
            }
        }
        for(int i = 2; i<=N; i++){
            System.out.println(parent[i]);
        }
    }

    private static void dfs(int n){
        if(check[n]){
            return;
        }
        check[n] = true;
        for(int now: arrayList[n]){
            if(!check[now]){
                parent[now] = n;
                dfs(now);
            }
        }
    }
}
