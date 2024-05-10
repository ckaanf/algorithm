import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 벨만-포드 알고리즘 진행 후 반환 값이 true 면 음수변환 아니면 최단거리 탐색
public class Main {
    static int N,M;
    static ArrayList<ArrayList<City>> arrayList;
    static long[] dist; // int 하니까 오버플로우 발생
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        dist = new long[N + 1];

        for(int i = 0; i<=N; i++){
            arrayList.add(new ArrayList<>());
            dist[i] = INF;
        }

        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            arrayList.get(A).add(new City(B, C));
        }

        StringBuilder sb = new StringBuilder();
        if(BF()){
            sb.append("-1\n");
        }else {
            for(int i =2; i<=N; i++){
                if(dist[i]==INF){
                    sb.append("-1\n");
                }else {
                    sb.append(dist[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    //레퍼런스 참고
    public static boolean BF(){
        dist[1] = 0;
        boolean update = false;

        //(정점 -1) 최단 거리 초기화
        for(int i = 1; i<N; i++){
            update = false;

            //최단거리 초기화 -> 플로이드 와샬 참고
            for(int j =1; j<=N; j++){
                for(City city: arrayList.get(j)){
                    if(dist[j] == INF){
                        break;
                    }
                    if(dist[city.end]>dist[j]+city.weight){
                        dist[city.end] = dist[j] + city.weight;
                        update = true;
                    }
                }
            }
            if(!update){
                break;
            }
        }

        //정점-1 까지 계속 업데이트 발생 시 정점 까지 업데이트 발생하면 음수 사이클
        if(update){
            for(int i =1; i<=N; i++){
                for(City city: arrayList.get(i)){
                    if(dist[i]==INF){
                        break;
                    }
                    if(dist[city.end]>dist[i]+ city.weight){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}


class City{
    int end;
    int weight;

    City(int end, int weight){
        this.end = end;
        this.weight = weight;
    }
}
