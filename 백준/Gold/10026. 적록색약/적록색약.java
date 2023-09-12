import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static boolean[][] visited;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N+1][N+1];
        visited = new boolean[N + 1][N + 1];
        int cnt = 0;
        for(int i = 0; i<N; i++){
            String s = br.readLine();
            for(int j = 0; j<N; j++){
                map[i][j] = s.charAt(j);
            }
        }
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }

        int cntRG =0;
        visited = new boolean[N + 1][N + 1];
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] == 'G'){
                    map[i][j] = 'R';
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cntRG++;
                }
            }
        }
        System.out.println(cnt+" "+cntRG);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        char color = map[x][y];

        for(int i =0; i<4; i++){
            int row = x+dx[i];
            int col = y+dy[i];
            if(row>=N || row<0||col>=N||col<0){
                continue;
            }
            if(!visited[row][col] && map[row][col] == color){
                dfs(row,col);
            }
        }

    }
}
