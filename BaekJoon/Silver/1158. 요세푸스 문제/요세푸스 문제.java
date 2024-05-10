import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        
        for(int i = 1; i<=n; i++){
            que.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(que.size() != 1){
            for(int i = 0; i < k-1; i ++){
                que.offer(que.poll());
            }
            sb.append(que.poll()).append(", ");
        }

        sb.append(que.poll()).append(">");

        System.out.println(sb);
    }
}

/*
요세푸스 순열 구하기
<N,K> n명의 사람이 제거 될때까지 k번 째 사람을 제거
1 2 3 4 5 6 7
3을 빼고 4 5 6 7 1 2
6을 빼고 7 1 2 4 5
2를 빼고 4 5 7 1
7을 빼고 1 4 5
5를 빼고 1 4
 */