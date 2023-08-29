import java.util.*;

class Solution {
    static ArrayList<Integer>[] node;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        
        node = new ArrayList[n+1];
        
        for(int i=1; i<=n; i++){
            node[i] = new ArrayList<>();
        }
        
        // 그래프 연결
        for(int i =0; i<wires.length; i++){
            int s = wires[i][0];   // 노드 두개 만들어 연결
            int e = wires[i][1];
            node[s].add(e);
            node[e].add(s);
        }
        // 이제 그래프 끊고 dfs 하는거 만들면 됨
        for(int i=0; i<wires.length; i++){
            int s = wires[i][0];
            int e = wires[i][1];
            
            boolean[] visited = new boolean[n+1];
            
            //연결 끊기
            node[s].remove(Integer.valueOf(e));
            node[e].remove(Integer.valueOf(s));
            
            // dfs에 넣어서 왼쪽 노드 오른쪽 노드 연결된 갯수 차이 Math.min하면 될듯한데
            int cnt = dfs(1,visited);
            int absolute = Math.abs(cnt - (n -cnt));
            
            min = Math.min(min,absolute);
            
            //아 끊어진 상태로 다음거를 계속 끊으면 안되니까 한번 끊었다가 다시 연결
            node[s].add(e);
            node[e].add(s);
            
        }
        
        return min;
    }
    
    
    public static int dfs(int n, boolean[] visited){
        visited[n] = true;
        int count =1;
        
        for(int next : node[n]){
            if(!visited[next]){
                count = count+dfs(next,visited);
            }
        }
        return count;
    }
}

// 노드의 연결을 하나씩 끊어 보면서, 송전탑의 절댓값이  Math.min 혹은 
// a > now -> a=now;