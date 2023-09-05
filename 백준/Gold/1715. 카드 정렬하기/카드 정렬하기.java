import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i<N; i++){
            int q = Integer.parseInt(br.readLine());
            pq.add(q);
        }

        int card1;
        int card2;
        int min = 0;

        while (pq.size() != 1){
            card1 = pq.remove();
            card2 = pq.remove();
            pq.add(card1+card2);
            min = min+ card1 + card2;
        }
        System.out.println(min);
    }
}
