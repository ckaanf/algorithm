import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<ArrayList<Integer>> map = new ArrayList<>();
        
        for(int i = 0; i<=n; i++){
            map.add(new ArrayList<Integer>());
        }
        
        for(int[] i : edge){
            int v = i[0];
            int w = i[1];
            map.get(v).add(w);
            map.get(w).add(v);
        }
        
        boolean[] visit = new boolean[n+1];
        return bfs(map,n,visit);
    }
    
    public static int bfs(List<ArrayList<Integer>> map, int n, boolean[] visit){
        Queue<int[]> q = new LinkedList<>();
        int answer = 0;
        
        q.add(new int[] {1,0});
        visit[1] = true;
        int maxDepth = 0;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int v = arr[0];
            int depth = arr[1];
            
            if(maxDepth == depth) answer++;
            else if(maxDepth < depth){
                maxDepth = depth;
                answer =1;
            }
            
            for(int i = 0; i<map.get(v).size(); i++){
                int w = map.get(v).get(i);
                if(!visit[w]){
                    q.add(new int[]{w,depth+1});
                    visit[w] = true;
                }
            }
        }
        return answer;
    }
}

// dfs나 bfs로 가장 끝의 노드를 탐색하고 depth가 가장 깊은 node들을 카운팅?