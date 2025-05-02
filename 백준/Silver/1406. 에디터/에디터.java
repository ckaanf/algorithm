import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'L':
                    if (left.empty()) break;
                    right.push(left.pop());
                    break;
                case 'D':
                    if (right.empty()) break;
                    left.push(right.pop());
                    break;
                case 'B':
                    if (left.empty()) break;
                    left.pop();
                    break;
                case 'P':
                    left.push(cmd.charAt(2));
                    break;
            }
        }

        while (!left.empty()) {
            right.push(left.pop());
        }

        StringBuilder sb = new StringBuilder();
        while (!right.empty()) {
            sb.append(right.pop());
        }

        System.out.println(sb.toString());

    }
}


/*
 * L 커서를 왼쪽으로 한 칸 옮김 (커서가 문장의 맨 앞이면 무시됨)
 * D 커서를 오른쪽으로 한 칸 옮김( 커서가 문장의 맨 뒤이면 무시됨)
 * B 커서 왼쪽에 있는 문자를 삭제함(커서가 문장의 맨 앞이면 무시됨)
 * 삭제로 인해 커서는
 */