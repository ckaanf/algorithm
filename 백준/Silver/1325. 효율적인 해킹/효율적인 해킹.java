import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] answer;
    static ArrayList<Integer>[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 1; i <= N; i++)
            arr[i] = new ArrayList<>();
        for (int j = 0; j < M; j++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }

        for(int i = 1; i<=N; i++){
            visited = new boolean[N + 1];
            BFS(i);
        }

        int max = 0;

        for(int i=1; i<=N;i++){
            max = Math.max(max, answer[i]);
        }

        for(int i = 1; i<=N; i++){
            if(answer[i] == max)
                System.out.print(i+" ");
        }
    }

    public static void BFS(int idx){
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        visited[idx] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i: arr[node]){
                if(!visited[i]){
                    visited[i] = true;
                    answer[i]++;
                    q.add(i);
                }
            }
        }
    }
}
