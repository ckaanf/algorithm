import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a,b;
        int G;
        int L;

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        G = gcd(a,b);

        System.out.println(G);
        System.out.println((a*b)/G);



    }
    static int gcd(int a, int b){
        int tmp,n;
        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}