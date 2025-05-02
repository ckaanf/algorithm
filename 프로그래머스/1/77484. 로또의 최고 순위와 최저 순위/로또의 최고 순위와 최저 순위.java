import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        
        int[] answer = new int[2];
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        
        for (int i : lottos) {
            if (i == 0) {
                answer[0]++;
                continue;
            }
            for (int j : win_nums) {
                if (i == j) {
                    // 일치하는 번호가 있으면 최고 순위와 최저 순위 모두 증가
                    answer[0]++;
                    answer[1]++;
                }
            }
        }
    
        answer[0] = rank[answer[0]];
        answer[1] = rank[answer[1]];
        return answer;  
    }
}

//알아볼 수 없는 번호 0
// set
//민우 44, 1, 0,0, 31,25
//당첨 31,10,45,1,6,19


// 순위
// 6 1등
// 5 2등
// 4 3등
// 3 4등
// 2 5등
// 그외 6등
