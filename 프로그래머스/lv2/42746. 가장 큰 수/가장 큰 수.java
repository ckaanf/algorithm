// 기본 컴퍼레이터 쓰니 3 30 에서 30 > 3 이됨 3>30으로 바꿔줘야하는 컴퍼레이터를 오버라이딩
import java.util.*;
//{9,5,34,30,3}
//         3,30 o1+o2 303 compareTo o2+o1 330
class Solution {
    public String solution(int[] numbers) {
        String answer ="";
        String[] s = new String[numbers.length];
        
        
        for(int i = 0; i<numbers.length; i++){
            s[i] = Integer.toString(numbers[i]);
        }
//       Arrays.sort(s, Collections.reverseOrder());
        Arrays.sort(s, (o1,o2)->(o2+o1).compareTo(o1+o2));
        
        // for(int i =0; i<s.length; i++){
        //     answer = answer+s[i];
        // }
    
        // 맨 앞이 0

        if(s[0].equals("0")) return "0";
        return String.join("",s); 
        // 정의가 되어있는 적당한 크기의 스트링 배열을 합칠 때는 builder보다 빠름
        // stringbuilder  string + string -> ab
    }
}

// 그냥 String 배열로 만들어서 정렬하면 한 자리자리 마다 정렬하니까 최댓값 나올거 같은데?