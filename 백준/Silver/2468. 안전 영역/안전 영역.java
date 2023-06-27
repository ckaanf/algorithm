import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] check;
    static int[] dx={1,0,-1,0};
    static int[] dy={0,-1,0,1};
    public static void main(String[] args) throws IOException {
        /*
        행렬 입력 받기
        입력 받은 행렬을 돌면서 높이에 따른 안전지대 BFS/DFS로 카운트
        cnt max 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        int h = 0;
        //행렬 입력
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > h){
                    h = map[i][j]; // 높이 for문을 위한 h 선정
                }
            }
        }

        // 안전지대 탐색은 레퍼런스 참고했습니다 ㅎㅎ;;
        int max = 0;
        for(int height = 0; height<h+1; height++){
            check = new boolean[n][n];
            int cnt = 0;
            for(int i = 0; i<n; i++){
                for(int j =0; j<n;j++){
                    if(map[i][j]>height && !check[i][j]){
                        cnt=cnt+DFS(i,j,height); // i,j
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        System.out.println(max);
    }

    static int DFS(int x, int y, int height){
        check[x][y] = true;
        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX<0 || nextY<0 || nextX>n-1|| nextY> n-1) continue;
            if(check[nextX][nextY]) continue;
            if(map[nextX][nextY]> height){
                DFS(nextX, nextY, height);
            }
        }
        return 1;
    }
}

// 높이 주어졌을때 높이 잠긴 애들은 못가는 걸로 or 이미 간곳 bfs/dfs
