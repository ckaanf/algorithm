import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, String> noSee = new HashMap<>();
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			noSee.put(s, s);
		}
		Map<String, String> noHear = new HashMap<>();
		for (int i = 1; i <= M; i++) {
			String s = br.readLine();
			noHear.put(s, s);
		}

		List<String> noSeeAndHear = new ArrayList<>();
		noSee.forEach((key, value) -> {
			if (noHear.containsKey(key)) {
				noSeeAndHear.add(value);
			}
		});
		Collections.sort(noSeeAndHear);

		System.out.println(noSeeAndHear.size());
		noSeeAndHear.forEach(System.out::println);
	}
}
