package boj.q12891_DNA_비밀번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    static int S, P, checkCnt;
    static char[] arr;
    static int[] checkArr, statusArr;

    static void input() {
        S = scan.nextInt();
        P = scan.nextInt();

        arr = new char[S];
        arr = scan.next().toCharArray();

        checkArr = new int[4];
        statusArr = new int[4];

        for (int i = 0; i < 4; i++) {
            checkArr[i] = scan.nextInt();
            if (checkArr[i] == 0)
                checkCnt++;
        }
    }

    static void pro() {

        int ans = 0;

        // 초기 슬라이딩 윈도우 범위 확인
        for (int i = 0; i < P; i++) {
            add(arr[i]);
        }
        if (checkCnt == 4)
            ans++;

        // 슬라이딩 윈도우 처리
        for (int i = P; i < S; i++) {
            add(arr[i]);
            remove(arr[i - P]);

            if (checkCnt == 4)
                ans++;
        }

        System.out.println(ans);
    }

    private static void add(char c) {
        switch (c) {
            case 'A':
                statusArr[0]++;
                if (statusArr[0] == checkArr[0])
                    checkCnt++;
                break;
            case 'C':
                statusArr[1]++;
                if (statusArr[1] == checkArr[1])
                    checkCnt++;
                break;
            case 'G':
                statusArr[2]++;
                if (statusArr[2] == checkArr[2])
                    checkCnt++;
                break;
            case 'T':
                statusArr[3]++;
                if (statusArr[3] == checkArr[3])
                    checkCnt++;
                break;
            default:
                throw new RuntimeException();
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A':
                if (statusArr[0] == checkArr[0])
                    checkCnt--;
                statusArr[0]--;
                break;
            case 'C':
                if (statusArr[1] == checkArr[1])
                    checkCnt--;
                statusArr[1]--;
                break;
            case 'G':
                if (statusArr[2] == checkArr[2])
                    checkCnt--;
                statusArr[2]--;
                break;
            case 'T':
                if (statusArr[3] == checkArr[3])
                    checkCnt--;
                statusArr[3]--;
                break;
            default:
                throw new RuntimeException();
        }
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
