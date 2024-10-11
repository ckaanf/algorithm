import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int n = 1;
		int k = 1;
		for (int i = 0; i < K; i++) {
			n = n * (N - i);
			k = k * (K - i);
		}
		System.out.println(n/k);
	}
}
