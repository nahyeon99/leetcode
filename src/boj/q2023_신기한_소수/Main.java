package boj.q2023_신기한_소수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) {

        N = scan.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

        System.out.println(sb);
    }

    static void DFS(int num, int loc) {

        if (loc == N) {
            if (isPrime(num))
                sb.append(num).append('\n');
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (isPrime(num * 10 + i))
                DFS(num * 10 + i, loc + 1);
        }
    }

    static boolean isPrime(int num) {

        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0)
                return false;
        }

        return true;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
