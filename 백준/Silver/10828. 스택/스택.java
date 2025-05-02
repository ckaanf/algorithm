//10828번 스택
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<>();                           // 입력받은 숫자 저장
        ArrayList<Integer> stack = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());                                          // 입력받은 숫자의 크기 만큼 list 작성
        }
        // for문을 돌면서 사용된 메서드 탐색
        for (int i = 0; i < n; i++) {
            if (list.get(i).contains(" ")) {
                push(stack, Integer.parseInt(list.get(i).substring(5)));
            }else if (list.get(i).equals("pop")){
                    System.out.println(pop(stack));
                }
            else if (list.get(i).equals("size")){
                System.out.println(size(stack));
            }
            else if (list.get(i).equals("empty")){
                System.out.println(empty(stack));
            }
            else if (list.get(i).equals("top")){
                System.out.println(top(stack));
            }
        }
    }
    // push X ()
    static void push(ArrayList<Integer> stack, int x) {
        stack.add(x);
    }

    // pop()
    static Integer pop(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return -1;
        } else {
            return stack.remove(stack.size() - 1);
        }
    }

    //size()
    static int size(ArrayList<Integer> stack) {
        return stack.size();
    }

    //top()
    static Integer top(ArrayList<Integer> stack) {
        if (stack.size() == 0) {
            return -1;
        } else {
            return stack.get(stack.size() - 1);
        }
    }

    //empty()
    static Integer empty(ArrayList<Integer> stack) {
        if (stack.size() == 0) return 1;
        else return 0;
    }
}