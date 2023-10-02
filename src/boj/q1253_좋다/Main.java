package boj.q1253_좋다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static int N;
    static int[] num;

    static void input() {

        N = scan.nextInt();
        num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = scan.nextInt();
        }
    }

    static void pro() {

        if (N < 2) {
            System.out.println(0);
            return;
        }

        Arrays.sort(num);
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (search(i))
                result++;
        }
        System.out.println(result);
    }

    static boolean search(int targetIdx) {

        int L = 0, R = N - 1;
        int target = num[targetIdx];

        while (L < R) {
            if (L == targetIdx)
                L++;
            else if (R == targetIdx)
                R--;
            else {
                int sum = num[L] + num[R];
                if (sum == target)
                    return true;
                else if (sum < target)
                    L++;
                else
                    R--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        input();
        pro();
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
