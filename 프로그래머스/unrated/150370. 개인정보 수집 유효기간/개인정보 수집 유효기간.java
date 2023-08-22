import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String,Integer> policy = new HashMap<>();
        
        int date = getDate(today);
        
        for(String s : terms){
            String[] term = s.split(" ");
            policy.put(term[0], Integer.parseInt(term[1]));
        }
        
        for(int i = 0; i<privacies.length; i++){
            String[] privacy = privacies[i].split(" ");
            
            if(getDate(privacy[0])+(policy.get(privacy[1])*28)<= date){// 28 -> 모든 달은 28일
                answer.add(i+1);
            } 
        }
       
        return answer.stream().mapToInt(integer->integer).toArray();
    }

    private int getDate(String today){
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]);
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);
        
        return (year * 12 * 28) + (month * 28) + day; // 계산하기 위해 day 로 변환 
    }
}

//<String,Integer> <정책, 기간>
// 그냥 잘 입력받아서 데이로 변환하든 datetime 을 활용하든..
// 꼼꼼히 체크했으면 될 듯..?
