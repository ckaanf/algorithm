import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] NM = br.readLine().split(" ");
        String[] nums_str = br.readLine().split(" ");

        int N = Integer.parseInt(NM[0]); 
        int M = Integer.parseInt(NM[1]); 

        int[] nums = new int[N]; 

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(nums_str[i]);
        }

        int answer = search(nums, N, M);

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();

    }

    // 탐색
    static int search(int[] nums, int N, int M) {
        int result = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {

                    int answer = nums[i] + nums[j] + nums[k];

                    if (M == answer) {
                        return answer;
                    }

                    if (result < answer && answer < M) {
                        result = answer;
                    }
                }
            }
        }

        return result;
    }
}
