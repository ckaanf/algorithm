import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((e1, e2) -> {
            int f_abs = Math.abs(e1);
            int s_abs = Math.abs(e2);
            if (f_abs == s_abs)
                return e1 > e2 ? 1 : -1;
            else
                return f_abs - s_abs;
        }); // q 정렬 기준 커스텀
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (q.isEmpty())
                    System.out.println("0");
                else
                    System.out.println(q.poll());
            } else {
                q.add(x);
            }
        }
    }
}

/*
N(x)
우선순위 큐 설정
- 절댓값 기준
- 같으면 음수 우선
for(N)
x = 0 ->q.isEmpty ==0
        false  == poll
x = 1 -> add 
 */
