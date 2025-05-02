import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer n = Integer.parseInt(br.readLine());

		long result = 1;

		if(n == 0) {
			System.out.println(result);
			return;
		}
		for(int i = 1; i <= n; i++) {
			result *= i;
		}
		System.out.println(result);
	}
}
