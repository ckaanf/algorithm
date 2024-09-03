import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(fun(n, r, c));
	}

	public static int fun(int n, int r, int c) {
		if (n == 0) return 0;
		int half = 1 << (n - 1);
		if (r < half && c < half) return fun(n - 1, r, c);
		if (r < half) return half * half + fun(n - 1, r, c - half);
		if (c < half) return 2 * half * half + fun(n - 1, r - half, c);
		return 3 * half * half + fun(n - 1, r - half, c - half);
	}
}
