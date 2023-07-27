// 2차원 배열로 구현 시 최댓값 20,000 *20,000 * 4byte로 1.6Gb 이므로 다른 방법 고민
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Node>[] list;
    private static int V;
    private static int E;
    private static int K;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        distance = new int[V+1];

        for(int i=1; i<=V; i++){
            list[i] = new ArrayList<>();
        }

        Arrays.fill(distance, INF);
        distance[K] =0;

        for(int i = 0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[u].add(new Node(v, w));

        }
        dijkstra();
        for(int i =1; i<=V; i++){
            if(distance[i]==INF){
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }
    }

    private static void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(K, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (distance[vertex] < weight) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {//해당 정점과 연결된 것들 탐색
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
    }

    private static class Node implements Comparable<Node> { //우선순위큐로 성능개선(안하면 시간초과뜸)
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}
