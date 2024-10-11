import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] clothes = new int[6];
		for (int i = 0; i < 6; i++) {
			clothes[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		// 배열 돌면서 clothes[i] % T + 1
		int t = 0;
		for (int clothe : clothes) {
			t += clothe / T;
			if(clothe % T != 0) {
				t++;
			}
		}
		// P 몫 나머지
		int p = N / P;
		int o = N % P;
		System.out.println(t);
		System.out.printf("%d %d", p, o);
	}
}
