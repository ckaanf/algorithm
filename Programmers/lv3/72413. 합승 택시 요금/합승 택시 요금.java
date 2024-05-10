import java.util.*;

class Node implements Comparable<Node>{
    int n;
    int w;
    
    Node(int n,int w){
        this.n = n;
        this.w = w;
    }
    
    @Override
     public int compareTo(Node n){
        return this.w - n.w;
    }
    
}


class Solution {
    
static final int MAX = Integer.MAX_VALUE;
static ArrayList<ArrayList<Node>> arrayList;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        
        arrayList = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }
        // 노드 연결 양방향
         for(int[] i : fares){
            arrayList.get(i[0]).add(new Node(i[1], i[2]));
            arrayList.get(i[1]).add(new Node(i[0], i[2]));
        }
        
        int[] A = new int[n+1];
        int[] B = new int[n+1];
        int[] AB = new int[n+1];
        
        
        A = dijkstra(a,A);
        B = dijkstra(b,B);
        AB = dijkstra(s,AB);
        
        // 세 개 다익 돌아서 최솟값으로..?
        //예를 들어 A 따로 B따로 와 AB의 값 비교 후 최솟값을 기록
        for(int i = 1; i <= n ; i ++) answer = Math.min(answer, A[i] + B[i] + AB[i]);
        return answer;
    }   
    
    static int[] dijkstra(int s, int[] costs){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(costs,Integer.MAX_VALUE);
        pq.add(new Node(s,0));
        costs[s] =0;
        
         while (!pq.isEmpty()) {
            Node now = pq.poll();
            int preN = now.n;
            int preW = now.w;

            if(preW > costs[preN]) continue;

            ArrayList<Node> nodes = arrayList.get(preN);
            for (Node node : nodes) {
                int cost = costs[preN] + node.w;

                if (cost < costs[node.n]) {
                    costs[node.n] = cost;
                    pq.add(new Node(node.n, cost));
                }
            }
        }
        return costs;
    }
    
}