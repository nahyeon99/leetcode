package boj.q11659_구간_합_구하기_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    static int numCnt, quicCnt;

    static void input() {
        numCnt = scan.nextInt();
        quicCnt = scan.nextInt();
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

    static void pro() {

        int[] arr = new int[numCnt + 1];

        // 합 배열 저장하기
        for (int i = 1; i <= numCnt; i++) {

            arr[i] = arr[i - 1] + scan.nextInt();
        }

        int idx1 = -1, idx2 = -1;
        // 구간 합 출력받기
        for (int i = 0; i < quicCnt; i++) {
            idx1 = scan.nextInt();
            idx2 = scan.nextInt();

            sb.append(arr[idx2] - arr[idx1 - 1]).append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}
