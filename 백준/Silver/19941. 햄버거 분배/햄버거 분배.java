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

		String s = br.readLine();
		char[] c = s.toCharArray();
		int[] h = new int[N];

		int eat = 0;

		for (int i = 0; i < N; i++) {
			if (c[i] == 'P') {
				for (int j = -K; j <= K; j++) {
					if (i + j >= N)
						break;
					if (i + j < 0)
						continue;

					if (c[i + j] == 'H' && h[i + j] == 0) {
						h[i + j] = 1;
						break;
					}
				}
			}
		}
		for (int i : h) {
			eat += i;
		}
		System.out.println(eat);
	}
}