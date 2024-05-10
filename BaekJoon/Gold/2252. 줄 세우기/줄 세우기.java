import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();

        for(int i =0; i<=N; i++){
            arrayList.add(new ArrayList<>());
        }

        int[] in = new int[N + 1];
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            arrayList.get(S).add(E);
            in[E]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =1; i<=N; i++){
            if(in[i]==0){
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int now = q.poll();
            System.out.print(now+" ");
            for (int next : arrayList.get(now)) {
                in[next]--;
                if (in[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}
