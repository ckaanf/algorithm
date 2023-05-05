import java.util.*;
class Solution
{
   	 public static int solution(int []A, int []B)
		    {
		        int answer = 0;
		        Arrays.sort(A);
		        Arrays.sort(B);
		        for(int i=0;i<A.length;i++) {
		        	
		        		answer=answer+(A[i]*B[A.length-i-1]);
		        	
		        }
		        System.out.println(answer);

		        return answer;
		    }
}

/*
A[0]*B[length-1] + A[1]*B[legth-2]+ ... +A[length-1]+B[0]
*/