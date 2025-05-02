import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int n_cnt = Integer.bitCount(n);
        int m_cnt = 0;
        
        while(true){
            n++;
            m_cnt = Integer.bitCount(n);
            if(n_cnt == m_cnt){
                answer =n;
                break;
            }
        }
        return answer;
    }
}