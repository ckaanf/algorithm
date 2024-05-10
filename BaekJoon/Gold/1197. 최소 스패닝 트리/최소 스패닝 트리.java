import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int n;
    int v;

    public Node(int n, int v){
        this.n = n;
        this.v = v;
    }

    @Override
    public int compareTo(Node o){
        return this.v - o.v;
    }
}
public class Main {
    static int min;
    static List<Node>[] node;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        node = new ArrayList[v + 1];
        visited = new boolean[v + 1];

        for(int i =1; i<v+1; i++){ // 리스트 초기화
            node[i] = new ArrayList<>();
        }

        for(int i = 0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            node[A].add(new Node(B, C));
            node[B].add(new Node(A, C));
        }
        dijk(1);
        System.out.println(min);
    }

    static void dijk(int now)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(now, 0));
        while (!pq.isEmpty()) {
            Node n = pq.poll();
            int node1 = n.n;
            int weight = n.v;

            if(visited[node1]) continue;
            visited[node1] = true;
            min += weight;

            for(Node next : node[node1]){
                if(!visited[next.n]){
                    pq.add(next);
                }
            }
        }
    }
}
