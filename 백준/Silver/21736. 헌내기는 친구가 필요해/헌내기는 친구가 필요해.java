import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] check;
    static char[][] campus;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int people = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus= new char[N][M];
        check = new boolean[N][M];

        // 시작 위치
        int x = 0;
        int y = 0;

        //배열 만들고 I 위치 찾아서 시작점 설정
        for(int i =0; i<N; i++){
            String s = br.readLine();
            for(int j=0; j<M; j++){
                campus[i][j] = s.charAt(j);
                if(campus[i][j]=='I'){
                    x=i;
                    y=j;
                }
            }
        }
        if(DFS(x,y) == 0) System.out.println("TT");
        else System.out.println(DFS(x,y));

    }
    public static int DFS(int x,int y){
        check[x][y] = true;

        if(campus[x][y] =='P') people++;

        for(int i=0; i<4; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            // 캠퍼스의 크기를 벗어나지 않고, 체크 하지 않은 곳
            if(nextX>=0 && nextY>=0&& nextX<N &&nextY<M&& !check[nextX][nextY]){
                if(campus[nextX][nextY] !='X'){
                    DFS(nextX,nextY);
                }
            }
        }
        return people;
    }
}
