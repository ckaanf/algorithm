import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int[][] tree;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        sc.nextLine();
        tree = new int[26][2];

        for(int i =0; i<N; i++){
            String[] tmp = sc.nextLine().split(" ");
            int node = tmp[0].charAt(0) - 'A';
            char left = tmp[1].charAt(0);
            char right = tmp[2].charAt(0);

            if(left == '.'){
                tree[node][0] = -1;
            }else {
                tree[node][0] = left - 'A';
            }
            if(right =='.'){
                tree[node][1] = -1;
            }else {
                tree[node][1] = right - 'A';
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
        System.out.println();
    }
    public static void preOrder(int n){
        if(n == -1)
            return;
        System.out.print((char)(n+'A'));
        preOrder(tree[n][0]);
        preOrder(tree[n][1]);
    }

    public static void inOrder(int n){
        if(n == -1)
            return;
        inOrder(tree[n][0]);
        System.out.print((char)(n+'A'));
        inOrder(tree[n][1]);
    }

    public static void postOrder(int n){
        if(n == -1)
            return;
        postOrder(tree[n][0]);
        postOrder(tree[n][1]);
        System.out.print((char)(n+'A'));
    }
}
