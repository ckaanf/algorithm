import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        boolean[][] matrixA = getMatrix();
        boolean[][] matrixB = getMatrix();

        System.out.println(solve(matrixA, matrixB));
    }

    private static int solve(boolean[][] matrixA, boolean[][] matrixB) {
        int cnt = 0;
        if (N < 3 || M < 3) {
            return isEqual(matrixA, matrixB) ? cnt : -1;  // 부분 행렬이 들어 갈 수 없는 크기는 -1 처음에 부분행렬이 부분만 들어가도 되는 줄 알아서 개고생함
        }

        for (int i = 0; i < M - 2; i++) { // 부분 행렬을 넣어주면서 값을 바꾸고 cnt ++
            for (int j = 0; j < N - 2; j++) {
                if (matrixA[i][j] ^ matrixB[i][j]) { // 비트 XOR 연산 두 행렬이 서로 다르면 true가 나와 토글 작동 자주 나오니 걍 외우면 됨 XOR은 토글에 쓴다
                    toggleMat(matrixA, i, j);
                    cnt++;
                }
            }
        }
        return isEqual(matrixA, matrixB) ? cnt : -1;
    }

    //토글해주는 메소드
    private static void toggleMat(boolean[][] matrixA, int row, int col) {
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                matrixA[i][j] = !matrixA[i][j];
            }
        }
    }

    private static boolean isEqual(boolean[][] matrixA, boolean[][] matrixB) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrixA[i][j] != matrixB[i][j]) return false;
            }
        }
        return true;
    }

    private static boolean[][] getMatrix() throws IOException {
        boolean[][] matrix = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                if (row.charAt(j) == '1') {
                    matrix[i][j] = true;
                } else {
                    matrix[i][j] = false;
                }
            }
        }

        return matrix;
    }
}