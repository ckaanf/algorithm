import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int solved[] = new int[n];

        for(int i =0; i<n; i++){
            solved[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(solved);

        int avg = (int) Math.round(n * 0.15);
        float sum =0;
        for(int i = avg ; i<n-avg; i++){
            sum = sum+solved[i];
        }
        int result =  Math.round(sum / (n - 2*avg));
        System.out.println(result);
    }
}
