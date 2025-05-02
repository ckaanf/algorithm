import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = 0;
		int sum = 0;

		st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int i = Integer.parseInt(st.nextToken());
			sum = sum + i;
			M = Math.max(M, i);
		}
		double avg = (double)sum / M * 100 / N;
		System.out.println(avg);
	}
}
