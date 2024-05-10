// Java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, W;
    static ArrayList<ArrayList<Node>> arrayList;
    static int[] dist;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            arrayList = new ArrayList<>();

            for (int i = 0; i <= N; i++) {
                arrayList.add(new ArrayList<>());
            }

            for (int i = 0; i < M + W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                if (i < M) { /// 도로는 방향이 없으며
                    arrayList.get(S).add(new Node(E, T));
                    arrayList.get(E).add(new Node(S, T));
                } else {
                    arrayList.get(S).add(new Node(E, -T));
                }
            }
            sb.append(BF() ? "YES\n" : "NO\n");
        }
        System.out.println(sb);
    }

    //전에 했던 타임머신에서 참고
    public static boolean BF() {
        Arrays.fill(dist, INF);
        dist[1] = 0;
        boolean update = false;

        // 정점 -1 최단거리 초기화
        for (int i = 1; i < N; i++) {
            update = false;

            for (int j = 1; j <= N; j++) {
                for (Node node : arrayList.get(j)) {
                    if (dist[node.m] > dist[j] + node.w) {
                        dist[node.m] = dist[j] + node.w;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;

            }
        }
        if(update){
            for(int i =1; i<=N; i++){
                for (Node node : arrayList.get(i)) {
                    if (dist[node.m] > dist[i] + node.w) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


class Node {
    int m;
    int w;

    Node(int m, int w) {
        this.m = m;
        this.w = w;
    }
}
