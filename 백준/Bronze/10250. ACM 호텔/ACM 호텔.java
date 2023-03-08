import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // T만큼 테스트 진행

        for (int i = 0; i < T; i++) {
            String[] HWN = br.readLine().split(" ");

            int H = Integer.parseInt(HWN[0]); // 호텔의 층 수
            int W = Integer.parseInt(HWN[1]); // 층마다 방의 갯수
            int N = Integer.parseInt(HWN[2]); // N번째 손님

            int floor = N % H; // 층 = 나머지 
            int ho = N / H + 1; // 호수 = 몫 + 1

            if (N % H == 0) { // 나머지가 0일 경우 
                floor = H * 100;
                ho = N / H;
            } else { // 아닐 경우
                floor = (N % H) * 100;
                ho = N / H + 1;
            }

            bw.write(floor + ho + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
