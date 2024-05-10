import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a,b;
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int i = a; i<=b;i++){
            if(is_Prime(i)) System.out.println(i);
        }
    }
    static boolean is_Prime(int Number) {

        // 1 은 소수가 아니다.
        if(Number == 1){
            return false;
        }

        for(int j = 2; j <= Math.sqrt(Number); j++) {

            if(Number % j == 0) return false;
        }

        return true;
    }
}