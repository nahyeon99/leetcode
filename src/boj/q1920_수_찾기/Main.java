package boj.q1920_수_찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] A;

    public static void main(String[] args) {

        N = scan.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }
        Arrays.sort(A);

        int querySize = scan.nextInt();
        for (int i = 0; i < querySize; i++) {
            int query = scan.nextInt();

            // bs
            boolean isFind = false;
            int L = 0, R = A.length - 1;

            while (L <= R) {
                int mid = (L + R) / 2;

                if (A[mid] == query) {
                    sb.append(1).append('\n');
                    isFind = true;
                    break;
                } else if (A[mid] < query) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
            if (!isFind)
                sb.append(0).append('\n');
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
