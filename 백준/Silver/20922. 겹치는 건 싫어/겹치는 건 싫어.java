import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int start = 0;
        int end = 0;
        int[] cnt = new int[100001];

        while(end <arr.length){
            while(end<arr.length && cnt[arr[end]] +1 <= K){
                cnt[arr[end]]++;
                end++;
            }
            int len = end-start;
            result = Math.max(result, len);
            cnt[arr[start]]--;
            start++;
        }
        System.out.println(result);
    }
}
