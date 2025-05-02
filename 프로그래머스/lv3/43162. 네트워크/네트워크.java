class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];
        
        for(int i = 0; i<n; i++){
            if(!check[i]){
                dfs(computers,i,check);
                answer++;
            }
        }
        
        return answer;
    }
    boolean[] dfs(int[][] computers, int n, boolean[] check){
        check[n] = true; // 방문했으니까 true로 바꿔주고
        
        for(int i =0; i<computers.length; i++){
            if(n != i && computers[n][i] == 1 && check[i] == false){
            // 자기가 아님 && 연결되어있음 && 들른곳 아님
                dfs(computers,i,check); //재귀로 그 위치에서 또 타고 들어가서 판단
            } 
        }
        return check;
    }
}


// 노드끼리 연결확인 탐색
// 서로 연결이 안되어 있는 노드 나올때 cnt ++