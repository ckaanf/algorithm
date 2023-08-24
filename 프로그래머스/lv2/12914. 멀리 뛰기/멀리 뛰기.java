class Solution {
    public long solution(int n) {
        int dp[] = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i =3; i<=n; i++){  
            dp[i]= (dp[i-2]+dp[i-1])%1234567;
        }          
        return dp[n];
    }
}

// n = 1 return = 1   [1]
// n = 2 return = 2   [1],[2]
// n = 3 return = 3   [1,1,1],[1,2],[2,1]
// n = 4 return = 5   [1,1,1,1],[1,2,1],[1,1,2],[2,1,1],[2,2]
// n = 5 return = 8
// n = 6 return = 13       
// dp[3] = dp[2]+1 -> dp[1];
// dp[4] = dp[3]+2;
// dp[5] = dp[4]+3;
// dp[6] = dp[5]+5;
// dp[7] = dp[6]+5?