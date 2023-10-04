package boj.q1377_버블_소트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    static class Data implements Comparable<Data> {
        int idx;
        int val;

        public Data(int idx, int val) {
            super();
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Data o) {
            return this.val - o.val;
        }
    }

    public static void main(String[] args) {

        int N = scan.nextInt();
        Data A[] = new Data[N];

        for (int i = 0; i < N; i++) {
            A[i] = new Data(i, scan.nextInt());
        }

        Arrays.sort(A);

        int max = 0;

        for (int i = 0; i < N; i++) {
            if (max < A[i].idx - i)
                max = A[i].idx - i;
        }

        System.out.println(max + 1);
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
