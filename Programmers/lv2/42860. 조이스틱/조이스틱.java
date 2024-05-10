import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int LR = name.length()-1;
        
        
        for(int i = 0; i<length; i++){
            
            answer += Math.min(name.charAt(i)-'A', 26-(name.charAt(i)-'A')); // 위아래에서 적은 수
                
            int end = i+1;
                while(end<length && name.charAt(end)=='A'){
                    end++;
                }
                LR = Math.min(LR,i+(length-end)+Math.min(i,length-end));
        }
    
        return answer+LR;
    }
}

//CBAAAAABC
// cnt= c[0]-'A'; 가 횟수 정하는 공식
// 맨처음엔 A로만 이루어져 있다 그 말은 A인 곳은 일단 제껴도 된다. 77-65 = 12
//

//A부터 시작이면
//A B C D E F G H I J K L M N O P Q R S T U V W X Y Z  26-(90-65)
//65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90
//    1 2   3  4  5  6  7  8  9  10 11 12 13 12 11 10 9 8 7 6  5  4  3   2   1
//A   A   A   A    A   A
//9 1 4 1 9 1 12 1 4 1 13 30 43  
//J   E   R   O    E

//target char가 n보다 작으면 위로 아니면 아래로 n 은 13회

//A  A  A
//9      13 1    
//J  A  N

//J A J N