import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;//정점개수
	static int M;//간선개수
	static int k;//시작정점
	static ArrayList<Integer> arr[];
	static boolean[] isVisit;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new ArrayList[N + 1];//좌표를그대로받아들이기위해+1사용
		isVisit = new boolean[N + 1];
		sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for(int i= 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			arr[s].add(e);
			arr[e].add(s);
		}

		for (ArrayList<Integer> integers : arr) {
			Collections.sort(integers);
		}

		dfs(k);
		isVisit = new boolean[N + 1];
		sb.append("\n");
		bfs(k);
		System.out.println(sb);
	}

	public static void dfs(int v) {
		isVisit[v] = true;
		sb.append(v).append(" ");
		for(int i : arr[v]){
			if(!isVisit[i]){
				dfs(i);
			}
		}
	}
	public static void bfs(int v){
		isVisit[v] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		while (!q.isEmpty()) {
			int a = q.poll();
			sb.append(a).append(" ");
			for(int i : arr[a]){
				if(!isVisit[i]){
					q.add(i);
					isVisit[i] = true;
				}
			}
		}
	}
}
