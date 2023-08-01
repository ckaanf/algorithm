import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static  int N;
    static int[][] map;
    static int[][] dijkstra;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static boolean boundary(int x, int y){
        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static class Node implements Comparable<Node>{
        int row, col, weight;

        public Node(int row,int col, int weight){
            super();
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int cnt = 0;

        StringBuilder sb = new StringBuilder();
        while (true){
            N = Integer.parseInt(br.readLine());
            if(N==0)
                break;
            map = new int[N][N];
            dijkstra = new int[N][N];

            for(int i =0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dijkstra[i][j] = Integer.MAX_VALUE;
                }
            }
            cnt++;
            sb.append("Problem ").append(cnt).append(": ").append(dijkstra()).append("\n");
        }
        System.out.println(sb);
        br.close();
    }



    private static int dijkstra(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        dijkstra[0][0] = map[0][0];
        queue.add(new Node(0, 0, map[0][0])); // 시작점

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i<4; i++){
                int nRow = node.row + dy[i];
                int nCol = node.col + dx[i];

                if(boundary(nRow,nCol)){
                    //기존 값이 weight 보다 작다면 교체
                    if (dijkstra[nRow][nCol] > dijkstra[node.row][node.col] + map[nRow][nCol]){
                        dijkstra[nRow][nCol] = dijkstra[node.row][node.col] + map[nRow][nCol];
                        queue.add(new Node(nRow, nCol, dijkstra[nRow][nCol]));
                    }
                }
            }
        }
        return dijkstra[N - 1][N - 1];
    }
}
