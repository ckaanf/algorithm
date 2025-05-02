import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer;
        int k = 0;
        if(n%2 == 0){
            answer = new int[n/2];
        }else{
            answer = new int[n/2+1];
        }
        
        for(int i = 0; i<=n; i++){
            if(i % 2 != 0){
                answer[k] = i;
                k++;
            }
        }
        return answer;
    }
}