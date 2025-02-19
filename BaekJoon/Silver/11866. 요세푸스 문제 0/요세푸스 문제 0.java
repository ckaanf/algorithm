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
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0; i < N; i++) {
			q.add(i + 1);
		}
		sb.append("<");
		while(!q.isEmpty()) {
			for (int i = 0; i < K; i++){
				if(i == K-1) {
					sb.append(q.poll()).append(", ");
				}
				else {
					q.add(q.poll());
				}
			}
		}
		sb.replace(sb.length()-2, sb.length(), ">");
		System.out.println(sb);
	}
}
