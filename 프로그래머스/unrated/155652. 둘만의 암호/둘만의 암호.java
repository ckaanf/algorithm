import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer="";
        char[] c = s.toCharArray();
        for(int i = 0; i<s.length(); i++){
            for(int j =0; j<index; j++){
                c[i]++; // --> ascii가 증가
                if(c[i]>'z'){
                    c[i] -=26;
                }
                if(skip.contains(String.valueOf(c[i]))){
                    j--; // j++ 상쇄 시켜줄라고
                }
            }
            answer = answer+c[i];
        }
        return answer;
    }
}
// 음.. 알파벳 배열 받아서 그냥 skip에 있는 알파벳 뺀 배열을 만들어서
// index만큼 넘겨주기?
// 문자열을..리터럴 배열로..흠
// for(int i) -> String s charAt(i) 를 받아서 이 char를 가지고
//  for(int j = 0 j<index j++){
//      charAt(i)++;
//     if(charAt(i) >26)
//         charAt(i) = charAt(i) - 26;
//     if(skip.contains(charAt(i))
//       j 안늘리기?
//  }
// u -> v w x y z