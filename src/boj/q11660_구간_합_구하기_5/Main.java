package boj.q11660_구간_합_구하기_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    static int numCnt, quizCnt;
    static int[][] A, D;

    static void input() {
        numCnt = scan.nextInt();
        quizCnt = scan.nextInt();
        A = new int[numCnt + 1][numCnt + 1];
        D = new int[numCnt + 1][numCnt + 1];

        // 원본 배열 입력받기
        for (int x = 1; x <= numCnt; x++) {
            for (int y = 1; y <= numCnt; y++) {
                A[x][y] = scan.nextInt();
            }
        }
    }

    static void pro() {

        // 구간 합 배열 저장하기
        for (int x = 1; x <= numCnt; x++) {
            for (int y = 1; y <= numCnt; y++) {
                D[x][y] = D[x-1][y] + D[x][y-1] + A[x][y] - D[x-1][y-1];
            }
        }

        // 구간 합 입력 / 결과 출력

        int x1, y1, x2, y2 = 0;
        for (int i = 0; i < quizCnt; i++) {
            x1 = scan.nextInt();
            y1 = scan.nextInt();
            x2 = scan.nextInt();
            y2 = scan.nextInt();

            sb.append(D[x2][y2] - D[x2][y1 - 1] - D[x1 - 1][y2] + D[x1 - 1][y1 - 1]).append("\n");
        }
        System.out.println(sb);
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
