import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		// 키의 합 100
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] dwarf = new int[9];

		int sum = 0;
		for(int i = 0; i < dwarf.length; i++){
			dwarf[i] = Integer.parseInt(br.readLine());
			sum += dwarf[i];
		}

		for(int i = 0; i<8; i++){
			for(int j = i+1; j<9; j++){
				if(sum-dwarf[i]-dwarf[j] == 100){
					dwarf[i]= 0;
					dwarf[j]= 0;
					Arrays.sort(dwarf);
					for(int n = 2; n<9; n++){
						System.out.println(dwarf[n]);
					}
					return;
				}
			}
		}
	}
}
