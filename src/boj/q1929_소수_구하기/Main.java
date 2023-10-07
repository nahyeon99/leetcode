package boj.q1929_소수_구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        int M = scan.nextInt();
        int N = scan.nextInt();

        int[] A = new int[N + 1];
        for (int i = 2; i <= N; i++)
            A[i] = i;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0)
                continue;

            for (int j = i * 2; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0)
                sb.append(A[i]).append('\n');
        }
        System.out.println(sb);
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
