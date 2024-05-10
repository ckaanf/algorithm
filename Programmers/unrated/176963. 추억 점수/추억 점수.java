import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String,Integer> map = new HashMap<>();
        for(int i =0; i<name.length; i++){
            map.put(name[i],yearning[i]);
        }
        

        for(int i = 0; i<photo.length; i++){
            String[] pList = photo[i];
            int result = 0;
            for(int j= 0; j<pList.length; j++){
                String p = pList[j];
                if(map.containsKey(p)){
                    result += map.get(p);
                }
            }
            answer[i] = result;
        }
        
        return answer;
    }
}

//Map<String, Integer> map<name,yearing> 로 맵만들고
// photo를 쭉 돌면서 name contains 면 밸류값 꺼내서 + 하면 될듯?