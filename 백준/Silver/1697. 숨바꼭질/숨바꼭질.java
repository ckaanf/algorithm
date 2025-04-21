import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  
        int K = Integer.parseInt(st.nextToken());  

        boolean[] visited = new boolean[100001];   
        Queue<Node> queue = new LinkedList<>();    
        queue.offer(new Node(N, 0));               
        visited[N] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.position == K) {
                System.out.println(current.depth);
                return;
            }
              
            int[] nextPositions = {current.position - 1, current.position + 1, current.position * 2};
            for (int next : nextPositions) {
                if (next >= 0 && next <= 100000 && !visited[next]) {
                    visited[next] = true;
                    queue.offer(new Node(next, current.depth + 1));
                }
            }
        }
    }

    public static class Node {
        int position;
        int depth;

        public Node(int position, int depth) {
            this.position = position;
            this.depth = depth;
        }
    }
}
