package boj.q11724_연결_요소의_개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    static ArrayList<Integer>[] A;
    static boolean[] isVisited;

    public static void main(String[] args) {

        int N = scan.nextInt();
        int M = scan.nextInt();

        A = new ArrayList[N+1];
        isVisited = new boolean[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {

            int v1 = scan.nextInt();
            int v2 = scan.nextInt();
            A[v1].add(v2);
            A[v2].add(v1);
        }

        int ans = 0;
        for (int i = 1; i < N+1; i++) {

            if (isVisited[i])
                continue;

            ans++;
            DFS(i);
        }
        System.out.println(ans);
    }

    static void DFS(int V) {
        if (isVisited[V])
            return;

        isVisited[V] = true;
        for (int i : A[V]) {
            if (!isVisited[i])
                DFS(i);
        }
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
