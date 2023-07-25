import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        for(int i =1; i<+N; i++){
            arr[i]=i;
        }

        for(int i = 1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=N; j++){
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 1){
                    union(i,j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int travel = find(Integer.parseInt(st.nextToken()));
        for(int i =1; i<M; i++){
            int pre = Integer.parseInt(st.nextToken());

            if (travel != find(pre)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");

    }

    public static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            arr[b] =a;
        }
    }

    public static int find(int a){
        if(a== arr[a])
            return a;
        else return arr[a] = find(arr[a]);
    }
}
