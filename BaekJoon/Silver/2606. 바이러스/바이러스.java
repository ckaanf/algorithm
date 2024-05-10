import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] arr;
    static boolean[] check;
    static int computer, pairComputer, start;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {

        //그래프 탐색 활용 방법 1) 인접 행렬 O(n^2) 미만 2) 인접 리스트 3) 인접 배열 택 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computer = Integer.parseInt(br.readLine());
        pairComputer = Integer.parseInt(br.readLine());
        start = 1;
        arr = new ArrayList[computer + 1];
        check = new boolean[computer + 1];

        // 리스트 생성
        for(int i = 1; i<=computer; i++){
            arr[i] = new ArrayList<Integer>();
        }

        //입력 받은 페어를 리스트로 연결
        for(int i = 0; i<pairComputer; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            arr[end].add(start);
            arr[start].add(end);
        }

        System.out.println(dfs(start));
    }
    
    // 입력 받은 컴퓨터가 리스트로 연결이 되어있으면 ++
    public static int dfs(int i){
        check[i] = true;
        for(int n : arr[i]){
            if(!check[n]){
                cnt++;
                dfs(n);
            }
        }
        return cnt;
    }
}
