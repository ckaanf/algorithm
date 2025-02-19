import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int T;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			List<Jiwon> jiwonList = new ArrayList<>();

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				int paper = Integer.parseInt(st.nextToken());
				int interview = Integer.parseInt(st.nextToken());

				jiwonList.add(new Jiwon(paper, interview));
			}
			Collections.sort(jiwonList);

			int hire = 1;
			int interviewMin = jiwonList.get(0).interview;

			for (int l = 1; l < N; l++) {
				if (jiwonList.get(l).interview < interviewMin) {
					hire++;
					interviewMin = jiwonList.get(l).interview;
				}

			}
			System.out.println(hire);
		}
	}

	static class Jiwon implements Comparable<Jiwon> {
		int paper;
		int interview;

		public Jiwon(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}

		@Override
		public int compareTo(Jiwon o) {
			if (this.paper > o.paper) {
				return 1;
			} else {
				return -1;
			}
		}
	}
}
