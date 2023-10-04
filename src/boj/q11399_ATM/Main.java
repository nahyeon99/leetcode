package boj.q11399_ATM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        int N = scan.nextInt();
        PriorityQueue<Integer> myQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            myQueue.add(scan.nextInt());
        }

        int wt = 0, ans = 0;

        for (int i = 0; i < N; i++) {
            int val = myQueue.poll();
            ans = ans + wt + val;
            wt += val;
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
