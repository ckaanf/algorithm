import java.util.Arrays;
class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] answer = {};
        answer = Arrays.stream(numlist).filter(value -> value % n == 0).toArray();
        return answer;
    }
}