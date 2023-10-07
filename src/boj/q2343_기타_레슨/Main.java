package boj.q2343_기타_레슨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        int N = scan.nextInt();
        int M = scan.nextInt();

        int[] A = new int[N];

        int L = 0, R = 0;
        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();

            if (L < A[i])
                L = A[i];

            R += A[i];
        }

        while (L <= R) {
            int mid = (L + R) / 2;
            int sum = 0, cnt = 0;

            for (int i = 0; i < N; i++) { // mid 크기의 블루레이에 강의 넣기
                if (sum + A[i] > mid) { // 블루레이에 현재 값 추가 시 사이즈 초과
                    cnt++;
                    sum = 0;
                }
                sum += A[i];
            }

            if (sum != 0)
                cnt++;

            if (cnt > M) // 불가능하므로 오른쪽 배열에서 탐색
                L = mid + 1;
            else // 가능하므로 왼쪽 배열에서 탐색
                R = mid - 1;
        }
        System.out.println(L);
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
