

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushroom = new int[10];

		for(int i = 0; i<10; i++){
			mushroom[i] = Integer.parseInt(br.readLine());
		}
		int result = 0;
		int sum = 0;
		for (int j : mushroom) {
			if(sum < 100){
				sum += j;
				if((100 - result) > ( sum - 100)){
					result = sum;
				} else if((100-result) == (sum-100)){
					result = result>sum? result: sum;
				}
			}
		}
		System.out.println(result);
	}
}
