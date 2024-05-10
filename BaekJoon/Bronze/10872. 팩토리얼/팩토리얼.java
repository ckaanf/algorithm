import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(fact(N));
    }
    static int fact(int n){
        if(n==0)
            return 1;
        if(n<=1)
            return n;
        else
            return fact(n - 1) * n;
    }
}

//n! = 1 x 2 x 3 x 4 x... x n