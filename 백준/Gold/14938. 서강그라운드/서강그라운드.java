import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node>{
    int n;
    int w;

    Node(int n, int w){
        this.n = n;
        this.w = w;
    }
    @Override
    public int compareTo(Node arg){
        return w - arg.w;
    }
}

public class Main {
    static int n,m,r;
    static int[] item;
    static ArrayList<ArrayList<Node>> arrayList;
    static int[] dist;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        item = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i =1; i<=r; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            arrayList.get(s).add(new Node(e, w));
            arrayList.get(e).add(new Node(s, w));
        }
        dist = new int[n + 1];
        check = new boolean[n + 1];

        int ans = 0;
        for(int i=1; i<=n; i++){
            ans = Math.max(ans, dijkstra(i));
        }
        System.out.println(ans + "\n");
        br.close();
    }

    public static int dijkstra(int s){
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(check,false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(s, 0));
        dist[s] =0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int n = node.n;

            if(!check[n]){
                check[n] = true;

                for(Node dnode : arrayList.get(n)){
                    if (!check[dnode.n] && dist[dnode.n] > dist[n] +dnode.w) {
                        dist[dnode.n] = dist[n] + dnode.w;
                        pq.add(new Node(dnode.n, dist[dnode.n]));
                    }
                }
            }
        }
        int res = 0;
        for(int i =1; i<=n; i++){
            if(dist[i]<=m){
                res += item[i];
            }
        }
        return res;
    }
}
