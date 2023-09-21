import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
    
        for(int i = 0; i<phone_book.length-1; i++){
            if(phone_book[i+1].startsWith(phone_book[i]))
                return false;
    }
            return true;
}
}
// 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false 않으면 true;
//