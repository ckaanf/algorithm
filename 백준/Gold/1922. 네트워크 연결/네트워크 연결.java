import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
    int s,e, v;

    Edge(int s,int e,int v){
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(Edge o){
        return this.v - o.v;
    }
}

public class Main {
    static PriorityQueue<Edge> edge;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        edge = new PriorityQueue<>();
        parent = new int[N + 1];
        for(int i =0; i<N; i++){
            parent[i] = i;
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edge.add(new Edge(s, e, v));
        }
        int useEdge =0;
        int result =0;
        while(useEdge <N-1){
            Edge now = edge.poll();
            if(find(now.s) != find(now.e)){
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        System.out.println(result);
    }


    public static void union(int a,int b){
        a = find(a);
        b = find(b);

        if(a != b){
            parent[b] =a;
        }
    }

    public static int find(int a){
        if (a == parent[a]) {
            return a;
        }
        else return parent[a]=find(parent[a]);
    }
}
