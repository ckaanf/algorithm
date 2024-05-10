import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char s[] = br.readLine().toCharArray();
        
        int sum = 0;
        int check = 0;
        
        for(int i =1; i<m-1; i++){
            if(s[i-1] =='I' && s[i] =='O' && s[i+1]=='I'){
                check++;
                if(check == n){
                    check--;
                    sum++;
                }
                i++;
            }
            else {
                check = 0;
            }
        }
        System.out.println(sum);
    }
}
