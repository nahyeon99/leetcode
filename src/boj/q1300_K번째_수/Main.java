package boj.q1300_K번째_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        int N = scan.nextInt();
        int K = scan.nextInt();

        long S = 1, E = K;
        long ans = 0;

        while (S <= E) {
            long M = (S + E) / 2;
            long cnt = 0;

            for (int i = 1; i <= N; i++) {
                cnt += Math.min(M / i, N);
            }

            if (cnt < K)
                S = M + 1;
            else {
                E = M - 1;
                ans = M;
            }
        }

        System.out.println(ans);
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
