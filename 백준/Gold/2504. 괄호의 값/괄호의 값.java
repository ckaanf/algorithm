import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();

		int len = str.length();
		int result = 0;
		int weight = 1;
		Stack<Character> s = new Stack<>();
		for (int i = 0; i < len; ++i) {
			char c = str.charAt(i);
			if (isOpenCharacter(c)) { // 여는 괄호열일 경우
				s.add(c); // 스택에 넣고
				weight *= getWeight(c); // 가중치를 곱해준다. ( 분배법칙 적용 )
			} else {
				if (!s.isEmpty() && isMatch(s.peek(), c)) { // 괄호열의 쌍이 맞다면, 식을 계산한다.
					if (c == ')') {
						if (str.charAt(i - 1) == '(') // 바로 직전이 여는 괄호열이였다면, 바로 숫자로 처리하여 계산
							result += weight;
						s.pop();
						weight /= 2; // 분배법칙이 함께 적용될 괄호가 종료되었음.
					} else {
						if (str.charAt(i - 1) == '[') // 바로 직전이 여는 괄호열이였다면, 바로 숫자로 처리하여 계산
							result += weight;
						s.pop();
						weight /= 3; // 분배법칙이 함께 적용될 괄호가 종료되었음.
					}
				} else { // 쌍이 안 맞는 경우 처리
					result = 0;
					break;
				}
			}
		}
		if (!s.isEmpty()) // 괄호열이 남았다. 올바르지 못한 괄호열이다.
			result = 0;

		System.out.println(result);
	}

	private static int getWeight(char c) {
		return c == '(' ? 2 : 3;
	}

	private static boolean isMatch(Character peek, char c) {
		if (peek == '(' && c == ')')
			return true;
		if (peek == '[' && c == ']')
			return true;
		return false;
	}

	private static boolean isOpenCharacter(char c) {
		return c == '(' || c == '[';
	}

	private static int stoi(String s) {
		return Integer.parseInt(s);
	}
}