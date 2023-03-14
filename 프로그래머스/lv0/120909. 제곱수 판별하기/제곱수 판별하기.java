class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 0;
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                num++;
            }
        }if(num % 2 ==0) return answer = 2;
        return answer = 1;
    }
}