class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int sum = (12000*n)+(2000*k);
        if(n>=10){
            int service = n/10;
            sum = sum- (service*2000);
        }
        
        return sum;
    }
}