import java.lang.Math;

class Solution {
    public int solution(int n, int t) {
        int answer = 0;
        double pow = Math.pow(2,t);
        answer = n*(int)pow;
        return answer;
    }
}