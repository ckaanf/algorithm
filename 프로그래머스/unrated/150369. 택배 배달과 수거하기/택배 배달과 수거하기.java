import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int del = 0;
        int pick = 0;
        long answer = 0;
        // 두 개 배열 0이 아닌 부분을 합쳐서 cap을 넘으면  answer에 더해주기
        // 최솟값 하려면 무조건 먼 곳에서 부터
        for(int i = n-1; i>=0; i--){
            if(deliveries[i] != 0 || pickups[i] != 0){
                int cnt =0;
                while(del < deliveries[i] || pick < pickups[i]){
                    cnt++;
                    del = del+cap; //  6
                    pick = pick+cap; // 8
                }
                del = del - deliveries[i]; // del = 2 , 3
                pick = pick - pickups[i];  // pick = 4, 8
                answer = answer+ ((long)(i+1)*cnt*2); // answer = 10 , 6
            }
        }   
        return answer;
    }
}

// 1 ,3 ,3 5 2 가 cap을 넘으면 answer 더하기?
//         
//         cap 4 5*2
//         3
//   cap 8 3 *2

//스택
// 배달 스택, 수거 스택
// 최상단 에서 부터 처리하면서 스택이 빌 때까지 