import java.util.*;


class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        ArrayList<Set<Integer>> set =new  ArrayList<>();
        
        // 리스트 초기화
        for(int i =0; i<9; i++){
             set.add(new HashSet<>());
        }
        //
        set.get(1).add(N); // 1 은 N
        
        for(int i =2; i<9; i++){
            // as-is
            //set.get(i)
            // to-be
            // set을 새로운 통에 아예 담기
            Set<Integer> a = set.get(i);
            for(int j= 1; j<=i; j++){
                Set<Integer> preSet = set.get(j);
                Set<Integer> ppreSet =set.get(i-j);
                
                for(int preNumber : preSet){
                    for(int ppreNumber : ppreSet){
                        a.add(preNumber + ppreNumber);
                        a.add(preNumber - ppreNumber);
                        a.add(preNumber * ppreNumber);
                        if(preNumber!=0 && ppreNumber!=0)
                        a.add(preNumber / ppreNumber);
                    }
                }
            }
            //N, NN,NNN 넣어야하는데..
             set.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }
            
        for(Set<Integer> idx : set){
            if(idx.contains(number)){
                return set.indexOf(idx);
            }
        }
        return -1;
    }
}

// n을 한개쓸때..n을 두개쓸때.... +
// 수가 아마 정해진 수식..? 의 규칙이 있을거 같은데..
//그리디와 DP의 결합느낌..

// N =2 number 2  -> 1
// N =2 number 4 -> 2+2 2*2 ->2
// N =4 number 4 -> 1  -> 4 -> 2+2 2*2