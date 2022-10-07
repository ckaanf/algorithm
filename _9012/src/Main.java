// 9012 괄호
/*
*()를 포함한 문자열을 계속 삭제하여 값이 없으면 YES 남으면 NO
* Scanner로 하니 오류가 나서 Br로 변경
 */
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cnt = Integer.parseInt(br.readLine());
        while(cnt-->0){
            String str = br.readLine();
            while(str.contains("()"))
                str = str.replace("()","");
            if(str.equals("")) bw.write("YES\n");
            else bw.write("NO\n");

        }
        bw.flush();
    }
}
