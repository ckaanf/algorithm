import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        sortedArr = Arrays.stream(arr).sorted().toArray();

        int order = 0;
        for(int in : sortedArr){
            if(!map.containsKey(in)){
                map.put(in, order);
                order++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<N; i++){
            int answer = map.get(arr[i]);
            sb.append(answer).append(' ');
        }
        System.out.println(sb);
    }
}
