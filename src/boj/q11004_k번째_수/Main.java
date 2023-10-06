package boj.q11004_k번째_수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {

        int N = scan.nextInt();
        int K = scan.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scan.nextInt();
        }

        quickSort(A, 0, N-1, K-1);
        System.out.println(A[K-1]);
    }

    static void quickSort(int[] A, int S, int E, int K) {

        if (S >= E)
            return;

        // 피벗 구하기
        int pivot = partition(A, S, E);
        if (pivot == K) // K번째 수가 pivot이면 탐색 종료
            return;
        else if (K < pivot) // K번째 수가 pivot보다 작으면 왼쪽 그룹만 정렬
            quickSort(A, S, pivot - 1, K);
        else  // K번째 수가 pivot보다 크면 오른쪽 그룹만 정렬
            quickSort(A, pivot + 1, E, K);
    }

    static int partition(int[] A, int S, int E) {
        if (S + 1 == E) { // 데이터 수가 2개인 경우
            if (A[S] > A[E])
                swap(A, S, E);
            return E;
        }

        int M = (S + E) / 2;
        swap(A, S, M);

        int pivot = A[S];
        int i = S + 1, j = E;

        while (i <= j) {
            while (pivot < A[j] && j > 0) // 피벗보다 작은 수가 나올 때까지
                j--;
            while (pivot > A[i] && i < A.length - 1) // 피벗보다 큰 수가 나올 떄까지
                i++;

            if (i <= j)
                swap(A, i++, j--);
        }
        // i == j 피벗의 값을 양쪽으로 분리한 가운데에 오도록 설정하기
        A[S] = A[j];
        A[j] = pivot;
        return j;
    }

    static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
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
