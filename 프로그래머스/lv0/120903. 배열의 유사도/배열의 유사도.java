class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        int count = 0;
        for(String s1Word : s1){
            for(String s2Word : s2){
                if(s2Word.equals(s1Word)) count ++;
            }
        }
        return count;
    }
}